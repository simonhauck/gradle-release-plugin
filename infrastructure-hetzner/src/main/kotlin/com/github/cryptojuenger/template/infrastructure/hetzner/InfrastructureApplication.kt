package com.github.cryptojuenger.template.infrastructure.hetzner

import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider
import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProviderConfig
import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server
import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerConfig
import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet
import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.ssh_key.SshKey
import com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.ssh_key.SshKeyConfig
import com.hashicorp.cdktf.App
import com.hashicorp.cdktf.TerraformOutput
import com.hashicorp.cdktf.TerraformOutputConfig
import com.hashicorp.cdktf.TerraformStack
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import software.constructs.Construct

@ConfigurationPropertiesScan
@SpringBootApplication
class InfrastructureApplication(private val hetznerProviderConfig: HetznerCloudConfig) :
    CommandLineRunner {
    override fun run(vararg args: String?) {
        val app = App()
        ApplicationServerStack(app, "application-server-stack", hetznerProviderConfig)
        app.synth()
    }
}

fun main(args: Array<String>) {
    runApplication<InfrastructureApplication>(*args)
}

@ConfigurationProperties(prefix = "hcloud")
data class HetznerCloudConfig(var token: String = "", var sshKeys: Map<String, String> = mapOf())

class ApplicationServerStack(scope: Construct, id: String, config: HetznerCloudConfig) :
    TerraformStack(scope, id) {
    init {

        HcloudProvider(
            this,
            "hcloud-provider",
            HcloudProviderConfig.builder().token(config.token).build()
        )

        val sshKeys =
            config.sshKeys.entries.map {
                SshKey(
                    this,
                    it.key,
                    SshKeyConfig.builder().name(it.key).publicKey(it.value).build()
                )
            }

        val applicationServer =
            Server(
                this,
                "application-server",
                ServerConfig.builder()
                    .name("application-server")
                    .image("ubuntu-22.04")
                    .serverType("cax11")
                    .datacenter("nbg1-dc3")
                    .publicNet(
                        listOf(
                            ServerPublicNet.builder().ipv4Enabled(true).ipv6Enabled(true).build()
                        )
                    )
                    .sshKeys(sshKeys.map { it.id })
                    .build()
            )

        TerraformOutput(
            this,
            "application-server-ipv4",
            TerraformOutputConfig.builder().value(applicationServer.ipv4Address).build()
        )
        TerraformOutput(
            this,
            "application-server-ipv6",
            TerraformOutputConfig.builder().value(applicationServer.ipv6Address).build()
        )
    }
}
