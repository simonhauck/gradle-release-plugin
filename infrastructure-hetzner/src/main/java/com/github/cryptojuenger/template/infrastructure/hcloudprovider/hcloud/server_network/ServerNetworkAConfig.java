package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server_network;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.362Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.serverNetwork.ServerNetworkAConfig")
@software.amazon.jsii.Jsii.Proxy(ServerNetworkAConfig.Jsii$Proxy.class)
public interface ServerNetworkAConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#server_id ServerNetworkA#server_id}.
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getServerId();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#alias_ips ServerNetworkA#alias_ips}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getAliasIps() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#id ServerNetworkA#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#ip ServerNetworkA#ip}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getIp() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#network_id ServerNetworkA#network_id}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getNetworkId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#subnet_id ServerNetworkA#subnet_id}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getSubnetId() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServerNetworkAConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServerNetworkAConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServerNetworkAConfig> {
        java.lang.Number serverId;
        java.util.List<java.lang.String> aliasIps;
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
         * Sets the value of {@link ServerNetworkAConfig#getServerId}
         * @param serverId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#server_id ServerNetworkA#server_id}. This parameter is required.
         * @return {@code this}
         */
        public Builder serverId(java.lang.Number serverId) {
            this.serverId = serverId;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getAliasIps}
         * @param aliasIps Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#alias_ips ServerNetworkA#alias_ips}.
         * @return {@code this}
         */
        public Builder aliasIps(java.util.List<java.lang.String> aliasIps) {
            this.aliasIps = aliasIps;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#id ServerNetworkA#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getIp}
         * @param ip Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#ip ServerNetworkA#ip}.
         * @return {@code this}
         */
        public Builder ip(java.lang.String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getNetworkId}
         * @param networkId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#network_id ServerNetworkA#network_id}.
         * @return {@code this}
         */
        public Builder networkId(java.lang.Number networkId) {
            this.networkId = networkId;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getSubnetId}
         * @param subnetId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server_network#subnet_id ServerNetworkA#subnet_id}.
         * @return {@code this}
         */
        public Builder subnetId(java.lang.String subnetId) {
            this.subnetId = subnetId;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getDependsOn}
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
         * Sets the value of {@link ServerNetworkAConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetworkAConfig#getProvisioners}
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
         * @return a new instance of {@link ServerNetworkAConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServerNetworkAConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link ServerNetworkAConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServerNetworkAConfig {
        private final java.lang.Number serverId;
        private final java.util.List<java.lang.String> aliasIps;
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
            this.serverId = software.amazon.jsii.Kernel.get(this, "serverId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.aliasIps = software.amazon.jsii.Kernel.get(this, "aliasIps", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
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
            this.serverId = java.util.Objects.requireNonNull(builder.serverId, "serverId is required");
            this.aliasIps = builder.aliasIps;
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
        public final java.lang.Number getServerId() {
            return this.serverId;
        }

        @Override
        public final java.util.List<java.lang.String> getAliasIps() {
            return this.aliasIps;
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

            data.set("serverId", om.valueToTree(this.getServerId()));
            if (this.getAliasIps() != null) {
                data.set("aliasIps", om.valueToTree(this.getAliasIps()));
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
            struct.set("fqn", om.valueToTree("hcloud.serverNetwork.ServerNetworkAConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerNetworkAConfig.Jsii$Proxy that = (ServerNetworkAConfig.Jsii$Proxy) o;

            if (!serverId.equals(that.serverId)) return false;
            if (this.aliasIps != null ? !this.aliasIps.equals(that.aliasIps) : that.aliasIps != null) return false;
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
            int result = this.serverId.hashCode();
            result = 31 * result + (this.aliasIps != null ? this.aliasIps.hashCode() : 0);
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
