package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.341Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceConfig")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerServiceConfig.Jsii$Proxy.class)
public interface LoadBalancerServiceConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#load_balancer_id LoadBalancerService#load_balancer_id}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getLoadBalancerId();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#protocol LoadBalancerService#protocol}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getProtocol();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#destination_port LoadBalancerService#destination_port}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getDestinationPort() {
        return null;
    }

    /**
     * health_check block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#health_check LoadBalancerService#health_check}
     */
    default @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck getHealthCheck() {
        return null;
    }

    /**
     * http block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#http LoadBalancerService#http}
     */
    default @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp getHttp() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#id LoadBalancerService#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#listen_port LoadBalancerService#listen_port}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getListenPort() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getProxyprotocol() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerServiceConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerServiceConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerServiceConfig> {
        java.lang.String loadBalancerId;
        java.lang.String protocol;
        java.lang.Number destinationPort;
        com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck healthCheck;
        com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp http;
        java.lang.String id;
        java.lang.Number listenPort;
        java.lang.Object proxyprotocol;
        java.lang.Object connection;
        java.lang.Object count;
        java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        com.hashicorp.cdktf.ITerraformIterator forEach;
        com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        com.hashicorp.cdktf.TerraformProvider provider;
        java.util.List<java.lang.Object> provisioners;

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getLoadBalancerId}
         * @param loadBalancerId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#load_balancer_id LoadBalancerService#load_balancer_id}. This parameter is required.
         * @return {@code this}
         */
        public Builder loadBalancerId(java.lang.String loadBalancerId) {
            this.loadBalancerId = loadBalancerId;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getProtocol}
         * @param protocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#protocol LoadBalancerService#protocol}. This parameter is required.
         * @return {@code this}
         */
        public Builder protocol(java.lang.String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getDestinationPort}
         * @param destinationPort Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#destination_port LoadBalancerService#destination_port}.
         * @return {@code this}
         */
        public Builder destinationPort(java.lang.Number destinationPort) {
            this.destinationPort = destinationPort;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getHealthCheck}
         * @param healthCheck health_check block.
         *                    Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#health_check LoadBalancerService#health_check}
         * @return {@code this}
         */
        public Builder healthCheck(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck healthCheck) {
            this.healthCheck = healthCheck;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getHttp}
         * @param http http block.
         *             Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#http LoadBalancerService#http}
         * @return {@code this}
         */
        public Builder http(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp http) {
            this.http = http;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#id LoadBalancerService#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getListenPort}
         * @param listenPort Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#listen_port LoadBalancerService#listen_port}.
         * @return {@code this}
         */
        public Builder listenPort(java.lang.Number listenPort) {
            this.listenPort = listenPort;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getProxyprotocol}
         * @param proxyprotocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}.
         * @return {@code this}
         */
        public Builder proxyprotocol(java.lang.Boolean proxyprotocol) {
            this.proxyprotocol = proxyprotocol;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getProxyprotocol}
         * @param proxyprotocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#proxyprotocol LoadBalancerService#proxyprotocol}.
         * @return {@code this}
         */
        public Builder proxyprotocol(com.hashicorp.cdktf.IResolvable proxyprotocol) {
            this.proxyprotocol = proxyprotocol;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getDependsOn}
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
         * Sets the value of {@link LoadBalancerServiceConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceConfig#getProvisioners}
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
         * @return a new instance of {@link LoadBalancerServiceConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerServiceConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerServiceConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerServiceConfig {
        private final java.lang.String loadBalancerId;
        private final java.lang.String protocol;
        private final java.lang.Number destinationPort;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck healthCheck;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp http;
        private final java.lang.String id;
        private final java.lang.Number listenPort;
        private final java.lang.Object proxyprotocol;
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
            this.loadBalancerId = software.amazon.jsii.Kernel.get(this, "loadBalancerId", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.protocol = software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.destinationPort = software.amazon.jsii.Kernel.get(this, "destinationPort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.healthCheck = software.amazon.jsii.Kernel.get(this, "healthCheck", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck.class));
            this.http = software.amazon.jsii.Kernel.get(this, "http", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp.class));
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.listenPort = software.amazon.jsii.Kernel.get(this, "listenPort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.proxyprotocol = software.amazon.jsii.Kernel.get(this, "proxyprotocol", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
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
            this.loadBalancerId = java.util.Objects.requireNonNull(builder.loadBalancerId, "loadBalancerId is required");
            this.protocol = java.util.Objects.requireNonNull(builder.protocol, "protocol is required");
            this.destinationPort = builder.destinationPort;
            this.healthCheck = builder.healthCheck;
            this.http = builder.http;
            this.id = builder.id;
            this.listenPort = builder.listenPort;
            this.proxyprotocol = builder.proxyprotocol;
            this.connection = builder.connection;
            this.count = builder.count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)builder.dependsOn;
            this.forEach = builder.forEach;
            this.lifecycle = builder.lifecycle;
            this.provider = builder.provider;
            this.provisioners = (java.util.List<java.lang.Object>)builder.provisioners;
        }

        @Override
        public final java.lang.String getLoadBalancerId() {
            return this.loadBalancerId;
        }

        @Override
        public final java.lang.String getProtocol() {
            return this.protocol;
        }

        @Override
        public final java.lang.Number getDestinationPort() {
            return this.destinationPort;
        }

        @Override
        public final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck getHealthCheck() {
            return this.healthCheck;
        }

        @Override
        public final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp getHttp() {
            return this.http;
        }

        @Override
        public final java.lang.String getId() {
            return this.id;
        }

        @Override
        public final java.lang.Number getListenPort() {
            return this.listenPort;
        }

        @Override
        public final java.lang.Object getProxyprotocol() {
            return this.proxyprotocol;
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

            data.set("loadBalancerId", om.valueToTree(this.getLoadBalancerId()));
            data.set("protocol", om.valueToTree(this.getProtocol()));
            if (this.getDestinationPort() != null) {
                data.set("destinationPort", om.valueToTree(this.getDestinationPort()));
            }
            if (this.getHealthCheck() != null) {
                data.set("healthCheck", om.valueToTree(this.getHealthCheck()));
            }
            if (this.getHttp() != null) {
                data.set("http", om.valueToTree(this.getHttp()));
            }
            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getListenPort() != null) {
                data.set("listenPort", om.valueToTree(this.getListenPort()));
            }
            if (this.getProxyprotocol() != null) {
                data.set("proxyprotocol", om.valueToTree(this.getProxyprotocol()));
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
            struct.set("fqn", om.valueToTree("hcloud.loadBalancerService.LoadBalancerServiceConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerServiceConfig.Jsii$Proxy that = (LoadBalancerServiceConfig.Jsii$Proxy) o;

            if (!loadBalancerId.equals(that.loadBalancerId)) return false;
            if (!protocol.equals(that.protocol)) return false;
            if (this.destinationPort != null ? !this.destinationPort.equals(that.destinationPort) : that.destinationPort != null) return false;
            if (this.healthCheck != null ? !this.healthCheck.equals(that.healthCheck) : that.healthCheck != null) return false;
            if (this.http != null ? !this.http.equals(that.http) : that.http != null) return false;
            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            if (this.listenPort != null ? !this.listenPort.equals(that.listenPort) : that.listenPort != null) return false;
            if (this.proxyprotocol != null ? !this.proxyprotocol.equals(that.proxyprotocol) : that.proxyprotocol != null) return false;
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
            int result = this.loadBalancerId.hashCode();
            result = 31 * result + (this.protocol.hashCode());
            result = 31 * result + (this.destinationPort != null ? this.destinationPort.hashCode() : 0);
            result = 31 * result + (this.healthCheck != null ? this.healthCheck.hashCode() : 0);
            result = 31 * result + (this.http != null ? this.http.hashCode() : 0);
            result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
            result = 31 * result + (this.listenPort != null ? this.listenPort.hashCode() : 0);
            result = 31 * result + (this.proxyprotocol != null ? this.proxyprotocol.hashCode() : 0);
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
