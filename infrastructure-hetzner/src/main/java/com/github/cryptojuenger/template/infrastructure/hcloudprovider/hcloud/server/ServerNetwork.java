package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.360Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.server.ServerNetwork")
@software.amazon.jsii.Jsii.Proxy(ServerNetwork.Jsii$Proxy.class)
public interface ServerNetwork extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network_id Server#network_id}.
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getNetworkId();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#alias_ips Server#alias_ips}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getAliasIps() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ip Server#ip}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getIp() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServerNetwork}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServerNetwork}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServerNetwork> {
        java.lang.Number networkId;
        java.util.List<java.lang.String> aliasIps;
        java.lang.String ip;

        /**
         * Sets the value of {@link ServerNetwork#getNetworkId}
         * @param networkId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network_id Server#network_id}. This parameter is required.
         * @return {@code this}
         */
        public Builder networkId(java.lang.Number networkId) {
            this.networkId = networkId;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetwork#getAliasIps}
         * @param aliasIps Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#alias_ips Server#alias_ips}.
         * @return {@code this}
         */
        public Builder aliasIps(java.util.List<java.lang.String> aliasIps) {
            this.aliasIps = aliasIps;
            return this;
        }

        /**
         * Sets the value of {@link ServerNetwork#getIp}
         * @param ip Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ip Server#ip}.
         * @return {@code this}
         */
        public Builder ip(java.lang.String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServerNetwork}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServerNetwork build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link ServerNetwork}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServerNetwork {
        private final java.lang.Number networkId;
        private final java.util.List<java.lang.String> aliasIps;
        private final java.lang.String ip;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.networkId = software.amazon.jsii.Kernel.get(this, "networkId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.aliasIps = software.amazon.jsii.Kernel.get(this, "aliasIps", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.ip = software.amazon.jsii.Kernel.get(this, "ip", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.networkId = java.util.Objects.requireNonNull(builder.networkId, "networkId is required");
            this.aliasIps = builder.aliasIps;
            this.ip = builder.ip;
        }

        @Override
        public final java.lang.Number getNetworkId() {
            return this.networkId;
        }

        @Override
        public final java.util.List<java.lang.String> getAliasIps() {
            return this.aliasIps;
        }

        @Override
        public final java.lang.String getIp() {
            return this.ip;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("networkId", om.valueToTree(this.getNetworkId()));
            if (this.getAliasIps() != null) {
                data.set("aliasIps", om.valueToTree(this.getAliasIps()));
            }
            if (this.getIp() != null) {
                data.set("ip", om.valueToTree(this.getIp()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.server.ServerNetwork"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerNetwork.Jsii$Proxy that = (ServerNetwork.Jsii$Proxy) o;

            if (!networkId.equals(that.networkId)) return false;
            if (this.aliasIps != null ? !this.aliasIps.equals(that.aliasIps) : that.aliasIps != null) return false;
            return this.ip != null ? this.ip.equals(that.ip) : that.ip == null;
        }

        @Override
        public final int hashCode() {
            int result = this.networkId.hashCode();
            result = 31 * result + (this.aliasIps != null ? this.aliasIps.hashCode() : 0);
            result = 31 * result + (this.ip != null ? this.ip.hashCode() : 0);
            return result;
        }
    }
}
