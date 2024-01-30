package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_network;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.340Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerNetwork.LoadBalancerNetworkConfig")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerNetworkConfig.Jsii$Proxy.class)
public interface LoadBalancerNetworkConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#load_balancer_id LoadBalancerNetwork#load_balancer_id}.
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getLoadBalancerId();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#enable_public_interface LoadBalancerNetwork#enable_public_interface}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getEnablePublicInterface() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#id LoadBalancerNetwork#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#ip LoadBalancerNetwork#ip}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getIp() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#network_id LoadBalancerNetwork#network_id}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getNetworkId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#subnet_id LoadBalancerNetwork#subnet_id}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getSubnetId() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerNetworkConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerNetworkConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerNetworkConfig> {
        java.lang.Number loadBalancerId;
        java.lang.Object enablePublicInterface;
        java.lang.String id;
        java.lang.String ip;
        java.lang.Number networkId;
        java.lang.String subnetId;
        java.lang.Object connection;
        java.lang.Object count;
        java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        com.hashicorp.cdktf.ITerraformIterator forEach;
        com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        com.hashicorp.cdktf.TerraformProvider provider;
        java.util.List<java.lang.Object> provisioners;

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getLoadBalancerId}
         * @param loadBalancerId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#load_balancer_id LoadBalancerNetwork#load_balancer_id}. This parameter is required.
         * @return {@code this}
         */
        public Builder loadBalancerId(java.lang.Number loadBalancerId) {
            this.loadBalancerId = loadBalancerId;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getEnablePublicInterface}
         * @param enablePublicInterface Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#enable_public_interface LoadBalancerNetwork#enable_public_interface}.
         * @return {@code this}
         */
        public Builder enablePublicInterface(java.lang.Boolean enablePublicInterface) {
            this.enablePublicInterface = enablePublicInterface;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getEnablePublicInterface}
         * @param enablePublicInterface Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#enable_public_interface LoadBalancerNetwork#enable_public_interface}.
         * @return {@code this}
         */
        public Builder enablePublicInterface(com.hashicorp.cdktf.IResolvable enablePublicInterface) {
            this.enablePublicInterface = enablePublicInterface;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#id LoadBalancerNetwork#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getIp}
         * @param ip Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#ip LoadBalancerNetwork#ip}.
         * @return {@code this}
         */
        public Builder ip(java.lang.String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getNetworkId}
         * @param networkId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#network_id LoadBalancerNetwork#network_id}.
         * @return {@code this}
         */
        public Builder networkId(java.lang.Number networkId) {
            this.networkId = networkId;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getSubnetId}
         * @param subnetId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_network#subnet_id LoadBalancerNetwork#subnet_id}.
         * @return {@code this}
         */
        public Builder subnetId(java.lang.String subnetId) {
            this.subnetId = subnetId;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getDependsOn}
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
         * Sets the value of {@link LoadBalancerNetworkConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerNetworkConfig#getProvisioners}
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
         * @return a new instance of {@link LoadBalancerNetworkConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerNetworkConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerNetworkConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerNetworkConfig {
        private final java.lang.Number loadBalancerId;
        private final java.lang.Object enablePublicInterface;
        private final java.lang.String id;
        private final java.lang.String ip;
        private final java.lang.Number networkId;
        private final java.lang.String subnetId;
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
            this.loadBalancerId = software.amazon.jsii.Kernel.get(this, "loadBalancerId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.enablePublicInterface = software.amazon.jsii.Kernel.get(this, "enablePublicInterface", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.ip = software.amazon.jsii.Kernel.get(this, "ip", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.networkId = software.amazon.jsii.Kernel.get(this, "networkId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.subnetId = software.amazon.jsii.Kernel.get(this, "subnetId", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
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
            this.enablePublicInterface = builder.enablePublicInterface;
            this.id = builder.id;
            this.ip = builder.ip;
            this.networkId = builder.networkId;
            this.subnetId = builder.subnetId;
            this.connection = builder.connection;
            this.count = builder.count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)builder.dependsOn;
            this.forEach = builder.forEach;
            this.lifecycle = builder.lifecycle;
            this.provider = builder.provider;
            this.provisioners = (java.util.List<java.lang.Object>)builder.provisioners;
        }

        @Override
        public final java.lang.Number getLoadBalancerId() {
            return this.loadBalancerId;
        }

        @Override
        public final java.lang.Object getEnablePublicInterface() {
            return this.enablePublicInterface;
        }

        @Override
        public final java.lang.String getId() {
            return this.id;
        }

        @Override
        public final java.lang.String getIp() {
            return this.ip;
        }

        @Override
        public final java.lang.Number getNetworkId() {
            return this.networkId;
        }

        @Override
        public final java.lang.String getSubnetId() {
            return this.subnetId;
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
            if (this.getEnablePublicInterface() != null) {
                data.set("enablePublicInterface", om.valueToTree(this.getEnablePublicInterface()));
            }
            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getIp() != null) {
                data.set("ip", om.valueToTree(this.getIp()));
            }
            if (this.getNetworkId() != null) {
                data.set("networkId", om.valueToTree(this.getNetworkId()));
            }
            if (this.getSubnetId() != null) {
                data.set("subnetId", om.valueToTree(this.getSubnetId()));
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
            struct.set("fqn", om.valueToTree("hcloud.loadBalancerNetwork.LoadBalancerNetworkConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerNetworkConfig.Jsii$Proxy that = (LoadBalancerNetworkConfig.Jsii$Proxy) o;

            if (!loadBalancerId.equals(that.loadBalancerId)) return false;
            if (this.enablePublicInterface != null ? !this.enablePublicInterface.equals(that.enablePublicInterface) : that.enablePublicInterface != null) return false;
            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            if (this.ip != null ? !this.ip.equals(that.ip) : that.ip != null) return false;
            if (this.networkId != null ? !this.networkId.equals(that.networkId) : that.networkId != null) return false;
            if (this.subnetId != null ? !this.subnetId.equals(that.subnetId) : that.subnetId != null) return false;
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
            result = 31 * result + (this.enablePublicInterface != null ? this.enablePublicInterface.hashCode() : 0);
            result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
            result = 31 * result + (this.ip != null ? this.ip.hashCode() : 0);
            result = 31 * result + (this.networkId != null ? this.networkId.hashCode() : 0);
            result = 31 * result + (this.subnetId != null ? this.subnetId.hashCode() : 0);
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
