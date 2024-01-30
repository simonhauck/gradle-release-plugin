package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.359Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.server.ServerConfig")
@software.amazon.jsii.Jsii.Proxy(ServerConfig.Jsii$Proxy.class)
public interface ServerConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#name Server#name}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#server_type Server#server_type}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getServerType();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getAllowDeprecatedImages() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getBackups() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#datacenter Server#datacenter}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getDatacenter() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getDeleteProtection() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#firewall_ids Server#firewall_ids}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.Number> getFirewallIds() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#id Server#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getIgnoreRemoteFirewallIds() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#image Server#image}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getImage() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#iso Server#iso}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getIso() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getKeepDisk() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#labels Server#labels}.
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getLabels() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#location Server#location}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getLocation() {
        return null;
    }

    /**
     * network block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network Server#network}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getNetwork() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#placement_group_id Server#placement_group_id}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getPlacementGroupId() {
        return null;
    }

    /**
     * public_net block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#public_net Server#public_net}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getPublicNet() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getRebuildProtection() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rescue Server#rescue}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getRescue() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getShutdownBeforeDeletion() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ssh_keys Server#ssh_keys}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getSshKeys() {
        return null;
    }

    /**
     * timeouts block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#timeouts Server#timeouts}
     */
    default @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts getTimeouts() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#user_data Server#user_data}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getUserData() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServerConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServerConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServerConfig> {
        java.lang.String name;
        java.lang.String serverType;
        java.lang.Object allowDeprecatedImages;
        java.lang.Object backups;
        java.lang.String datacenter;
        java.lang.Object deleteProtection;
        java.util.List<java.lang.Number> firewallIds;
        java.lang.String id;
        java.lang.Object ignoreRemoteFirewallIds;
        java.lang.String image;
        java.lang.String iso;
        java.lang.Object keepDisk;
        java.util.Map<java.lang.String, java.lang.String> labels;
        java.lang.String location;
        java.lang.Object network;
        java.lang.Number placementGroupId;
        java.lang.Object publicNet;
        java.lang.Object rebuildProtection;
        java.lang.String rescue;
        java.lang.Object shutdownBeforeDeletion;
        java.util.List<java.lang.String> sshKeys;
        com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts timeouts;
        java.lang.String userData;
        java.lang.Object connection;
        java.lang.Object count;
        java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        com.hashicorp.cdktf.ITerraformIterator forEach;
        com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        com.hashicorp.cdktf.TerraformProvider provider;
        java.util.List<java.lang.Object> provisioners;

        /**
         * Sets the value of {@link ServerConfig#getName}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#name Server#name}. This parameter is required.
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getServerType}
         * @param serverType Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#server_type Server#server_type}. This parameter is required.
         * @return {@code this}
         */
        public Builder serverType(java.lang.String serverType) {
            this.serverType = serverType;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getAllowDeprecatedImages}
         * @param allowDeprecatedImages Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}.
         * @return {@code this}
         */
        public Builder allowDeprecatedImages(java.lang.Boolean allowDeprecatedImages) {
            this.allowDeprecatedImages = allowDeprecatedImages;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getAllowDeprecatedImages}
         * @param allowDeprecatedImages Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}.
         * @return {@code this}
         */
        public Builder allowDeprecatedImages(com.hashicorp.cdktf.IResolvable allowDeprecatedImages) {
            this.allowDeprecatedImages = allowDeprecatedImages;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getBackups}
         * @param backups Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}.
         * @return {@code this}
         */
        public Builder backups(java.lang.Boolean backups) {
            this.backups = backups;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getBackups}
         * @param backups Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}.
         * @return {@code this}
         */
        public Builder backups(com.hashicorp.cdktf.IResolvable backups) {
            this.backups = backups;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getDatacenter}
         * @param datacenter Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#datacenter Server#datacenter}.
         * @return {@code this}
         */
        public Builder datacenter(java.lang.String datacenter) {
            this.datacenter = datacenter;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getDeleteProtection}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}.
         * @return {@code this}
         */
        public Builder deleteProtection(java.lang.Boolean deleteProtection) {
            this.deleteProtection = deleteProtection;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getDeleteProtection}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}.
         * @return {@code this}
         */
        public Builder deleteProtection(com.hashicorp.cdktf.IResolvable deleteProtection) {
            this.deleteProtection = deleteProtection;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getFirewallIds}
         * @param firewallIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#firewall_ids Server#firewall_ids}.
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder firewallIds(java.util.List<? extends java.lang.Number> firewallIds) {
            this.firewallIds = (java.util.List<java.lang.Number>)firewallIds;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#id Server#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getIgnoreRemoteFirewallIds}
         * @param ignoreRemoteFirewallIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}.
         * @return {@code this}
         */
        public Builder ignoreRemoteFirewallIds(java.lang.Boolean ignoreRemoteFirewallIds) {
            this.ignoreRemoteFirewallIds = ignoreRemoteFirewallIds;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getIgnoreRemoteFirewallIds}
         * @param ignoreRemoteFirewallIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}.
         * @return {@code this}
         */
        public Builder ignoreRemoteFirewallIds(com.hashicorp.cdktf.IResolvable ignoreRemoteFirewallIds) {
            this.ignoreRemoteFirewallIds = ignoreRemoteFirewallIds;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getImage}
         * @param image Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#image Server#image}.
         * @return {@code this}
         */
        public Builder image(java.lang.String image) {
            this.image = image;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getIso}
         * @param iso Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#iso Server#iso}.
         * @return {@code this}
         */
        public Builder iso(java.lang.String iso) {
            this.iso = iso;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getKeepDisk}
         * @param keepDisk Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}.
         * @return {@code this}
         */
        public Builder keepDisk(java.lang.Boolean keepDisk) {
            this.keepDisk = keepDisk;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getKeepDisk}
         * @param keepDisk Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}.
         * @return {@code this}
         */
        public Builder keepDisk(com.hashicorp.cdktf.IResolvable keepDisk) {
            this.keepDisk = keepDisk;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getLabels}
         * @param labels Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#labels Server#labels}.
         * @return {@code this}
         */
        public Builder labels(java.util.Map<java.lang.String, java.lang.String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getLocation}
         * @param location Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#location Server#location}.
         * @return {@code this}
         */
        public Builder location(java.lang.String location) {
            this.location = location;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getNetwork}
         * @param network network block.
         *                Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network Server#network}
         * @return {@code this}
         */
        public Builder network(com.hashicorp.cdktf.IResolvable network) {
            this.network = network;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getNetwork}
         * @param network network block.
         *                Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network Server#network}
         * @return {@code this}
         */
        public Builder network(java.util.List<? extends com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetwork> network) {
            this.network = network;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getPlacementGroupId}
         * @param placementGroupId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#placement_group_id Server#placement_group_id}.
         * @return {@code this}
         */
        public Builder placementGroupId(java.lang.Number placementGroupId) {
            this.placementGroupId = placementGroupId;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getPublicNet}
         * @param publicNet public_net block.
         *                  Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#public_net Server#public_net}
         * @return {@code this}
         */
        public Builder publicNet(com.hashicorp.cdktf.IResolvable publicNet) {
            this.publicNet = publicNet;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getPublicNet}
         * @param publicNet public_net block.
         *                  Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#public_net Server#public_net}
         * @return {@code this}
         */
        public Builder publicNet(java.util.List<? extends com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet> publicNet) {
            this.publicNet = publicNet;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getRebuildProtection}
         * @param rebuildProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}.
         * @return {@code this}
         */
        public Builder rebuildProtection(java.lang.Boolean rebuildProtection) {
            this.rebuildProtection = rebuildProtection;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getRebuildProtection}
         * @param rebuildProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}.
         * @return {@code this}
         */
        public Builder rebuildProtection(com.hashicorp.cdktf.IResolvable rebuildProtection) {
            this.rebuildProtection = rebuildProtection;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getRescue}
         * @param rescue Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rescue Server#rescue}.
         * @return {@code this}
         */
        public Builder rescue(java.lang.String rescue) {
            this.rescue = rescue;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getShutdownBeforeDeletion}
         * @param shutdownBeforeDeletion Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}.
         * @return {@code this}
         */
        public Builder shutdownBeforeDeletion(java.lang.Boolean shutdownBeforeDeletion) {
            this.shutdownBeforeDeletion = shutdownBeforeDeletion;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getShutdownBeforeDeletion}
         * @param shutdownBeforeDeletion Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}.
         * @return {@code this}
         */
        public Builder shutdownBeforeDeletion(com.hashicorp.cdktf.IResolvable shutdownBeforeDeletion) {
            this.shutdownBeforeDeletion = shutdownBeforeDeletion;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getSshKeys}
         * @param sshKeys Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ssh_keys Server#ssh_keys}.
         * @return {@code this}
         */
        public Builder sshKeys(java.util.List<java.lang.String> sshKeys) {
            this.sshKeys = sshKeys;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getTimeouts}
         * @param timeouts timeouts block.
         *                 Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#timeouts Server#timeouts}
         * @return {@code this}
         */
        public Builder timeouts(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts timeouts) {
            this.timeouts = timeouts;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getUserData}
         * @param userData Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#user_data Server#user_data}.
         * @return {@code this}
         */
        public Builder userData(java.lang.String userData) {
            this.userData = userData;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getDependsOn}
         * @param dependsOn the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder dependsOn(java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link ServerConfig#getProvisioners}
         * @param provisioners the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder provisioners(java.util.List<? extends java.lang.Object> provisioners) {
            this.provisioners = (java.util.List<java.lang.Object>)provisioners;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServerConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServerConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link ServerConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServerConfig {
        private final java.lang.String name;
        private final java.lang.String serverType;
        private final java.lang.Object allowDeprecatedImages;
        private final java.lang.Object backups;
        private final java.lang.String datacenter;
        private final java.lang.Object deleteProtection;
        private final java.util.List<java.lang.Number> firewallIds;
        private final java.lang.String id;
        private final java.lang.Object ignoreRemoteFirewallIds;
        private final java.lang.String image;
        private final java.lang.String iso;
        private final java.lang.Object keepDisk;
        private final java.util.Map<java.lang.String, java.lang.String> labels;
        private final java.lang.String location;
        private final java.lang.Object network;
        private final java.lang.Number placementGroupId;
        private final java.lang.Object publicNet;
        private final java.lang.Object rebuildProtection;
        private final java.lang.String rescue;
        private final java.lang.Object shutdownBeforeDeletion;
        private final java.util.List<java.lang.String> sshKeys;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts timeouts;
        private final java.lang.String userData;
        private final java.lang.Object connection;
        private final java.lang.Object count;
        private final java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private final com.hashicorp.cdktf.ITerraformIterator forEach;
        private final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private final com.hashicorp.cdktf.TerraformProvider provider;
        private final java.util.List<java.lang.Object> provisioners;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.serverType = software.amazon.jsii.Kernel.get(this, "serverType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.allowDeprecatedImages = software.amazon.jsii.Kernel.get(this, "allowDeprecatedImages", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.backups = software.amazon.jsii.Kernel.get(this, "backups", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.datacenter = software.amazon.jsii.Kernel.get(this, "datacenter", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.deleteProtection = software.amazon.jsii.Kernel.get(this, "deleteProtection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.firewallIds = software.amazon.jsii.Kernel.get(this, "firewallIds", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class)));
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.ignoreRemoteFirewallIds = software.amazon.jsii.Kernel.get(this, "ignoreRemoteFirewallIds", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.image = software.amazon.jsii.Kernel.get(this, "image", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.iso = software.amazon.jsii.Kernel.get(this, "iso", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.keepDisk = software.amazon.jsii.Kernel.get(this, "keepDisk", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.labels = software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.location = software.amazon.jsii.Kernel.get(this, "location", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.network = software.amazon.jsii.Kernel.get(this, "network", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.placementGroupId = software.amazon.jsii.Kernel.get(this, "placementGroupId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.publicNet = software.amazon.jsii.Kernel.get(this, "publicNet", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.rebuildProtection = software.amazon.jsii.Kernel.get(this, "rebuildProtection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.rescue = software.amazon.jsii.Kernel.get(this, "rescue", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.shutdownBeforeDeletion = software.amazon.jsii.Kernel.get(this, "shutdownBeforeDeletion", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.sshKeys = software.amazon.jsii.Kernel.get(this, "sshKeys", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.timeouts = software.amazon.jsii.Kernel.get(this, "timeouts", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts.class));
            this.userData = software.amazon.jsii.Kernel.get(this, "userData", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.connection = software.amazon.jsii.Kernel.get(this, "connection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.count = software.amazon.jsii.Kernel.get(this, "count", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.dependsOn = software.amazon.jsii.Kernel.get(this, "dependsOn", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformDependable.class)));
            this.forEach = software.amazon.jsii.Kernel.get(this, "forEach", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformIterator.class));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformResourceLifecycle.class));
            this.provider = software.amazon.jsii.Kernel.get(this, "provider", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformProvider.class));
            this.provisioners = software.amazon.jsii.Kernel.get(this, "provisioners", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.name = java.util.Objects.requireNonNull(builder.name, "name is required");
            this.serverType = java.util.Objects.requireNonNull(builder.serverType, "serverType is required");
            this.allowDeprecatedImages = builder.allowDeprecatedImages;
            this.backups = builder.backups;
            this.datacenter = builder.datacenter;
            this.deleteProtection = builder.deleteProtection;
            this.firewallIds = (java.util.List<java.lang.Number>)builder.firewallIds;
            this.id = builder.id;
            this.ignoreRemoteFirewallIds = builder.ignoreRemoteFirewallIds;
            this.image = builder.image;
            this.iso = builder.iso;
            this.keepDisk = builder.keepDisk;
            this.labels = builder.labels;
            this.location = builder.location;
            this.network = builder.network;
            this.placementGroupId = builder.placementGroupId;
            this.publicNet = builder.publicNet;
            this.rebuildProtection = builder.rebuildProtection;
            this.rescue = builder.rescue;
            this.shutdownBeforeDeletion = builder.shutdownBeforeDeletion;
            this.sshKeys = builder.sshKeys;
            this.timeouts = builder.timeouts;
            this.userData = builder.userData;
            this.connection = builder.connection;
            this.count = builder.count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)builder.dependsOn;
            this.forEach = builder.forEach;
            this.lifecycle = builder.lifecycle;
            this.provider = builder.provider;
            this.provisioners = (java.util.List<java.lang.Object>)builder.provisioners;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.String getServerType() {
            return this.serverType;
        }

        @Override
        public final java.lang.Object getAllowDeprecatedImages() {
            return this.allowDeprecatedImages;
        }

        @Override
        public final java.lang.Object getBackups() {
            return this.backups;
        }

        @Override
        public final java.lang.String getDatacenter() {
            return this.datacenter;
        }

        @Override
        public final java.lang.Object getDeleteProtection() {
            return this.deleteProtection;
        }

        @Override
        public final java.util.List<java.lang.Number> getFirewallIds() {
            return this.firewallIds;
        }

        @Override
        public final java.lang.String getId() {
            return this.id;
        }

        @Override
        public final java.lang.Object getIgnoreRemoteFirewallIds() {
            return this.ignoreRemoteFirewallIds;
        }

        @Override
        public final java.lang.String getImage() {
            return this.image;
        }

        @Override
        public final java.lang.String getIso() {
            return this.iso;
        }

        @Override
        public final java.lang.Object getKeepDisk() {
            return this.keepDisk;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getLabels() {
            return this.labels;
        }

        @Override
        public final java.lang.String getLocation() {
            return this.location;
        }

        @Override
        public final java.lang.Object getNetwork() {
            return this.network;
        }

        @Override
        public final java.lang.Number getPlacementGroupId() {
            return this.placementGroupId;
        }

        @Override
        public final java.lang.Object getPublicNet() {
            return this.publicNet;
        }

        @Override
        public final java.lang.Object getRebuildProtection() {
            return this.rebuildProtection;
        }

        @Override
        public final java.lang.String getRescue() {
            return this.rescue;
        }

        @Override
        public final java.lang.Object getShutdownBeforeDeletion() {
            return this.shutdownBeforeDeletion;
        }

        @Override
        public final java.util.List<java.lang.String> getSshKeys() {
            return this.sshKeys;
        }

        @Override
        public final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts getTimeouts() {
            return this.timeouts;
        }

        @Override
        public final java.lang.String getUserData() {
            return this.userData;
        }

        @Override
        public final java.lang.Object getConnection() {
            return this.connection;
        }

        @Override
        public final java.lang.Object getCount() {
            return this.count;
        }

        @Override
        public final java.util.List<com.hashicorp.cdktf.ITerraformDependable> getDependsOn() {
            return this.dependsOn;
        }

        @Override
        public final com.hashicorp.cdktf.ITerraformIterator getForEach() {
            return this.forEach;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformResourceLifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformProvider getProvider() {
            return this.provider;
        }

        @Override
        public final java.util.List<java.lang.Object> getProvisioners() {
            return this.provisioners;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("name", om.valueToTree(this.getName()));
            data.set("serverType", om.valueToTree(this.getServerType()));
            if (this.getAllowDeprecatedImages() != null) {
                data.set("allowDeprecatedImages", om.valueToTree(this.getAllowDeprecatedImages()));
            }
            if (this.getBackups() != null) {
                data.set("backups", om.valueToTree(this.getBackups()));
            }
            if (this.getDatacenter() != null) {
                data.set("datacenter", om.valueToTree(this.getDatacenter()));
            }
            if (this.getDeleteProtection() != null) {
                data.set("deleteProtection", om.valueToTree(this.getDeleteProtection()));
            }
            if (this.getFirewallIds() != null) {
                data.set("firewallIds", om.valueToTree(this.getFirewallIds()));
            }
            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getIgnoreRemoteFirewallIds() != null) {
                data.set("ignoreRemoteFirewallIds", om.valueToTree(this.getIgnoreRemoteFirewallIds()));
            }
            if (this.getImage() != null) {
                data.set("image", om.valueToTree(this.getImage()));
            }
            if (this.getIso() != null) {
                data.set("iso", om.valueToTree(this.getIso()));
            }
            if (this.getKeepDisk() != null) {
                data.set("keepDisk", om.valueToTree(this.getKeepDisk()));
            }
            if (this.getLabels() != null) {
                data.set("labels", om.valueToTree(this.getLabels()));
            }
            if (this.getLocation() != null) {
                data.set("location", om.valueToTree(this.getLocation()));
            }
            if (this.getNetwork() != null) {
                data.set("network", om.valueToTree(this.getNetwork()));
            }
            if (this.getPlacementGroupId() != null) {
                data.set("placementGroupId", om.valueToTree(this.getPlacementGroupId()));
            }
            if (this.getPublicNet() != null) {
                data.set("publicNet", om.valueToTree(this.getPublicNet()));
            }
            if (this.getRebuildProtection() != null) {
                data.set("rebuildProtection", om.valueToTree(this.getRebuildProtection()));
            }
            if (this.getRescue() != null) {
                data.set("rescue", om.valueToTree(this.getRescue()));
            }
            if (this.getShutdownBeforeDeletion() != null) {
                data.set("shutdownBeforeDeletion", om.valueToTree(this.getShutdownBeforeDeletion()));
            }
            if (this.getSshKeys() != null) {
                data.set("sshKeys", om.valueToTree(this.getSshKeys()));
            }
            if (this.getTimeouts() != null) {
                data.set("timeouts", om.valueToTree(this.getTimeouts()));
            }
            if (this.getUserData() != null) {
                data.set("userData", om.valueToTree(this.getUserData()));
            }
            if (this.getConnection() != null) {
                data.set("connection", om.valueToTree(this.getConnection()));
            }
            if (this.getCount() != null) {
                data.set("count", om.valueToTree(this.getCount()));
            }
            if (this.getDependsOn() != null) {
                data.set("dependsOn", om.valueToTree(this.getDependsOn()));
            }
            if (this.getForEach() != null) {
                data.set("forEach", om.valueToTree(this.getForEach()));
            }
            if (this.getLifecycle() != null) {
                data.set("lifecycle", om.valueToTree(this.getLifecycle()));
            }
            if (this.getProvider() != null) {
                data.set("provider", om.valueToTree(this.getProvider()));
            }
            if (this.getProvisioners() != null) {
                data.set("provisioners", om.valueToTree(this.getProvisioners()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.server.ServerConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerConfig.Jsii$Proxy that = (ServerConfig.Jsii$Proxy) o;

            if (!name.equals(that.name)) return false;
            if (!serverType.equals(that.serverType)) return false;
            if (this.allowDeprecatedImages != null ? !this.allowDeprecatedImages.equals(that.allowDeprecatedImages) : that.allowDeprecatedImages != null) return false;
            if (this.backups != null ? !this.backups.equals(that.backups) : that.backups != null) return false;
            if (this.datacenter != null ? !this.datacenter.equals(that.datacenter) : that.datacenter != null) return false;
            if (this.deleteProtection != null ? !this.deleteProtection.equals(that.deleteProtection) : that.deleteProtection != null) return false;
            if (this.firewallIds != null ? !this.firewallIds.equals(that.firewallIds) : that.firewallIds != null) return false;
            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            if (this.ignoreRemoteFirewallIds != null ? !this.ignoreRemoteFirewallIds.equals(that.ignoreRemoteFirewallIds) : that.ignoreRemoteFirewallIds != null) return false;
            if (this.image != null ? !this.image.equals(that.image) : that.image != null) return false;
            if (this.iso != null ? !this.iso.equals(that.iso) : that.iso != null) return false;
            if (this.keepDisk != null ? !this.keepDisk.equals(that.keepDisk) : that.keepDisk != null) return false;
            if (this.labels != null ? !this.labels.equals(that.labels) : that.labels != null) return false;
            if (this.location != null ? !this.location.equals(that.location) : that.location != null) return false;
            if (this.network != null ? !this.network.equals(that.network) : that.network != null) return false;
            if (this.placementGroupId != null ? !this.placementGroupId.equals(that.placementGroupId) : that.placementGroupId != null) return false;
            if (this.publicNet != null ? !this.publicNet.equals(that.publicNet) : that.publicNet != null) return false;
            if (this.rebuildProtection != null ? !this.rebuildProtection.equals(that.rebuildProtection) : that.rebuildProtection != null) return false;
            if (this.rescue != null ? !this.rescue.equals(that.rescue) : that.rescue != null) return false;
            if (this.shutdownBeforeDeletion != null ? !this.shutdownBeforeDeletion.equals(that.shutdownBeforeDeletion) : that.shutdownBeforeDeletion != null) return false;
            if (this.sshKeys != null ? !this.sshKeys.equals(that.sshKeys) : that.sshKeys != null) return false;
            if (this.timeouts != null ? !this.timeouts.equals(that.timeouts) : that.timeouts != null) return false;
            if (this.userData != null ? !this.userData.equals(that.userData) : that.userData != null) return false;
            if (this.connection != null ? !this.connection.equals(that.connection) : that.connection != null) return false;
            if (this.count != null ? !this.count.equals(that.count) : that.count != null) return false;
            if (this.dependsOn != null ? !this.dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
            if (this.forEach != null ? !this.forEach.equals(that.forEach) : that.forEach != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            if (this.provider != null ? !this.provider.equals(that.provider) : that.provider != null) return false;
            return this.provisioners != null ? this.provisioners.equals(that.provisioners) : that.provisioners == null;
        }

        @Override
        public final int hashCode() {
            int result = this.name.hashCode();
            result = 31 * result + (this.serverType.hashCode());
            result = 31 * result + (this.allowDeprecatedImages != null ? this.allowDeprecatedImages.hashCode() : 0);
            result = 31 * result + (this.backups != null ? this.backups.hashCode() : 0);
            result = 31 * result + (this.datacenter != null ? this.datacenter.hashCode() : 0);
            result = 31 * result + (this.deleteProtection != null ? this.deleteProtection.hashCode() : 0);
            result = 31 * result + (this.firewallIds != null ? this.firewallIds.hashCode() : 0);
            result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
            result = 31 * result + (this.ignoreRemoteFirewallIds != null ? this.ignoreRemoteFirewallIds.hashCode() : 0);
            result = 31 * result + (this.image != null ? this.image.hashCode() : 0);
            result = 31 * result + (this.iso != null ? this.iso.hashCode() : 0);
            result = 31 * result + (this.keepDisk != null ? this.keepDisk.hashCode() : 0);
            result = 31 * result + (this.labels != null ? this.labels.hashCode() : 0);
            result = 31 * result + (this.location != null ? this.location.hashCode() : 0);
            result = 31 * result + (this.network != null ? this.network.hashCode() : 0);
            result = 31 * result + (this.placementGroupId != null ? this.placementGroupId.hashCode() : 0);
            result = 31 * result + (this.publicNet != null ? this.publicNet.hashCode() : 0);
            result = 31 * result + (this.rebuildProtection != null ? this.rebuildProtection.hashCode() : 0);
            result = 31 * result + (this.rescue != null ? this.rescue.hashCode() : 0);
            result = 31 * result + (this.shutdownBeforeDeletion != null ? this.shutdownBeforeDeletion.hashCode() : 0);
            result = 31 * result + (this.sshKeys != null ? this.sshKeys.hashCode() : 0);
            result = 31 * result + (this.timeouts != null ? this.timeouts.hashCode() : 0);
            result = 31 * result + (this.userData != null ? this.userData.hashCode() : 0);
            result = 31 * result + (this.connection != null ? this.connection.hashCode() : 0);
            result = 31 * result + (this.count != null ? this.count.hashCode() : 0);
            result = 31 * result + (this.dependsOn != null ? this.dependsOn.hashCode() : 0);
            result = 31 * result + (this.forEach != null ? this.forEach.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.provider != null ? this.provider.hashCode() : 0);
            result = 31 * result + (this.provisioners != null ? this.provisioners.hashCode() : 0);
            return result;
        }
    }
}
