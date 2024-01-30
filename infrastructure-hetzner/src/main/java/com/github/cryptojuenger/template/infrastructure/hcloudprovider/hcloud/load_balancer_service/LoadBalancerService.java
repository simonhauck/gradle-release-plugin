package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service hcloud_load_balancer_service}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.340Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerService")
public class LoadBalancerService extends com.hashicorp.cdktf.TerraformResource {

    protected LoadBalancerService(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected LoadBalancerService(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service hcloud_load_balancer_service} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public LoadBalancerService(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    /**
     * Generates CDKTF code for importing a LoadBalancerService resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the LoadBalancerService to import. This parameter is required.
     * @param importFromId The id of the existing LoadBalancerService that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the LoadBalancerService to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a LoadBalancerService resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the LoadBalancerService to import. This parameter is required.
     * @param importFromId The id of the existing LoadBalancerService that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void putHealthCheck(final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck value) {
        software.amazon.jsii.Kernel.call(this, "putHealthCheck", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void putHttp(final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp value) {
        software.amazon.jsii.Kernel.call(this, "putHttp", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void resetDestinationPort() {
        software.amazon.jsii.Kernel.call(this, "resetDestinationPort", software.amazon.jsii.NativeType.VOID);
    }

    public void resetHealthCheck() {
        software.amazon.jsii.Kernel.call(this, "resetHealthCheck", software.amazon.jsii.NativeType.VOID);
    }

    public void resetHttp() {
        software.amazon.jsii.Kernel.call(this, "resetHttp", software.amazon.jsii.NativeType.VOID);
    }

    public void resetId() {
        software.amazon.jsii.Kernel.call(this, "resetId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetListenPort() {
        software.amazon.jsii.Kernel.call(this, "resetListenPort", software.amazon.jsii.NativeType.VOID);
    }

    public void resetProxyprotocol() {
        software.amazon.jsii.Kernel.call(this, "resetProxyprotocol", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeHclAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeHclAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public final static java.lang.String TF_RESOURCE_TYPE;

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckOutputReference getHealthCheck() {
        return software.amazon.jsii.Kernel.get(this, "healthCheck", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckOutputReference.class));
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttpOutputReference getHttp() {
        return software.amazon.jsii.Kernel.get(this, "http", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttpOutputReference.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getDestinationPortInput() {
        return software.amazon.jsii.Kernel.get(this, "destinationPortInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck getHealthCheckInput() {
        return software.amazon.jsii.Kernel.get(this, "healthCheckInput", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck.class));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp getHttpInput() {
        return software.amazon.jsii.Kernel.get(this, "httpInput", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getIdInput() {
        return software.amazon.jsii.Kernel.get(this, "idInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getListenPortInput() {
        return software.amazon.jsii.Kernel.get(this, "listenPortInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getLoadBalancerIdInput() {
        return software.amazon.jsii.Kernel.get(this, "loadBalancerIdInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getProtocolInput() {
        return software.amazon.jsii.Kernel.get(this, "protocolInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getProxyprotocolInput() {
        return software.amazon.jsii.Kernel.get(this, "proxyprotocolInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getDestinationPort() {
        return software.amazon.jsii.Kernel.get(this, "destinationPort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setDestinationPort(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "destinationPort", java.util.Objects.requireNonNull(value, "destinationPort is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setId(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "id", java.util.Objects.requireNonNull(value, "id is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getListenPort() {
        return software.amazon.jsii.Kernel.get(this, "listenPort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setListenPort(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "listenPort", java.util.Objects.requireNonNull(value, "listenPort is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLoadBalancerId() {
        return software.amazon.jsii.Kernel.get(this, "loadBalancerId", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setLoadBalancerId(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "loadBalancerId", java.util.Objects.requireNonNull(value, "loadBalancerId is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getProtocol() {
        return software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setProtocol(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "protocol", java.util.Objects.requireNonNull(value, "protocol is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getProxyprotocol() {
        return software.amazon.jsii.Kernel.get(this, "proxyprotocol", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setProxyprotocol(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "proxyprotocol", java.util.Objects.requireNonNull(value, "proxyprotocol is required"));
    }

    public void setProxyprotocol(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "proxyprotocol", java.util.Objects.requireNonNull(value, "proxyprotocol is required"));
    }

    /**
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService> {
        /**
         * @return a new instance of {@link Builder}.
         * @param scope The scope in which to define this construct. This parameter is required.
         * @param id The scoped construct ID. This parameter is required.
         */
        public static Builder create(final software.constructs.Construct scope, final java.lang.String id) {
            return new Builder(scope, id);
        }

        private final software.constructs.Construct scope;
        private final java.lang.String id;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceConfig.Builder();
        }

        /**
         * @return {@code this}
         * @param connection This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(final com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.config.connection(connection);
            return this;
        }
        /**
         * @return {@code this}
         * @param connection This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(final com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.config.connection(connection);
            return this;
        }

        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final java.lang.Number count) {
            this.config.count(count);
            return this;
        }
        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final com.hashicorp.cdktf.TerraformCount count) {
            this.config.count(count);
            return this;
        }

        /**
         * @return {@code this}
         * @param dependsOn This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder dependsOn(final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.config.dependsOn(dependsOn);
            return this;
        }

        /**
         * @return {@code this}
         * @param forEach This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(final com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.config.forEach(forEach);
            return this;
        }

        /**
         * @return {@code this}
         * @param lifecycle This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.config.lifecycle(lifecycle);
            return this;
        }

        /**
         * @return {@code this}
         * @param provider This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(final com.hashicorp.cdktf.TerraformProvider provider) {
            this.config.provider(provider);
            return this;
        }

        /**
         * @return {@code this}
         * @param provisioners This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provisioners(final java.util.List<? extends java.lang.Object> provisioners) {
            this.config.provisioners(provisioners);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#load_balancer_id LoadBalancerService#load_balancer_id}.
         * <p>
         * @return {@code this}
         * @param loadBalancerId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#load_balancer_id LoadBalancerService#load_balancer_id}. This parameter is required.
         */
        public Builder loadBalancerId(final java.lang.String loadBalancerId) {
            this.config.loadBalancerId(loadBalancerId);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#protocol LoadBalancerService#protocol}.
         * <p>
         * @return {@code this}
         * @param protocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#protocol LoadBalancerService#protocol}. This parameter is required.
         */
        public Builder protocol(final java.lang.String protocol) {
            this.config.protocol(protocol);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#destination_port LoadBalancerService#destination_port}.
         * <p>
         * @return {@code this}
         * @param destinationPort Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#destination_port LoadBalancerService#destination_port}. This parameter is required.
         */
        public Builder destinationPort(final java.lang.Number destinationPort) {
            this.config.destinationPort(destinationPort);
            return this;
        }

        /**
         * health_check block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#health_check LoadBalancerService#health_check}
         * <p>
         * @return {@code this}
         * @param healthCheck health_check block. This parameter is required.
         */
        public Builder healthCheck(final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck healthCheck) {
            this.config.healthCheck(healthCheck);
            return this;
        }

        /**
         * http block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#http LoadBalancerService#http}
         * <p>
         * @return {@code this}
         * @param http http block. This parameter is required.
         */
        public Builder http(final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp http) {
            this.config.http(http);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#id LoadBalancerService#id}.
         * <p>
         * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * <p>
         * @return {@code this}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#id LoadBalancerService#id}. This parameter is required.
         */
        public Builder id(final java.lang.String id) {
            this.config.id(id);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#listen_port LoadBalancerService#listen_port}.
         * <p>
         * @return {@code this}
         * @param listenPort Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#listen_port LoadBalancerService#listen_port}. This parameter is required.
         */
        public Builder listenPort(final java.lang.Number listenPort) {
            this.config.listenPort(listenPort);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}.
         * <p>
         * @return {@code this}
         * @param proxyprotocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}. This parameter is required.
         */
        public Builder proxyprotocol(final java.lang.Boolean proxyprotocol) {
            this.config.proxyprotocol(proxyprotocol);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}.
         * <p>
         * @return {@code this}
         * @param proxyprotocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}. This parameter is required.
         */
        public Builder proxyprotocol(final com.hashicorp.cdktf.IResolvable proxyprotocol) {
            this.config.proxyprotocol(proxyprotocol);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerService(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
