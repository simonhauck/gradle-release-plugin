package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.361Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.server.ServerPublicNet")
@software.amazon.jsii.Jsii.Proxy(ServerPublicNet.Jsii$Proxy.class)
public interface ServerPublicNet extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv4 Server#ipv4}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getIpv4() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv4_enabled Server#ipv4_enabled}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getIpv4Enabled() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv6 Server#ipv6}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getIpv6() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv6_enabled Server#ipv6_enabled}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getIpv6Enabled() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServerPublicNet}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServerPublicNet}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServerPublicNet> {
        java.lang.Number ipv4;
        java.lang.Object ipv4Enabled;
        java.lang.Number ipv6;
        java.lang.Object ipv6Enabled;

        /**
         * Sets the value of {@link ServerPublicNet#getIpv4}
         * @param ipv4 Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv4 Server#ipv4}.
         * @return {@code this}
         */
        public Builder ipv4(java.lang.Number ipv4) {
            this.ipv4 = ipv4;
            return this;
        }

        /**
         * Sets the value of {@link ServerPublicNet#getIpv4Enabled}
         * @param ipv4Enabled Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv4_enabled Server#ipv4_enabled}.
         * @return {@code this}
         */
        public Builder ipv4Enabled(java.lang.Boolean ipv4Enabled) {
            this.ipv4Enabled = ipv4Enabled;
            return this;
        }

        /**
         * Sets the value of {@link ServerPublicNet#getIpv4Enabled}
         * @param ipv4Enabled Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv4_enabled Server#ipv4_enabled}.
         * @return {@code this}
         */
        public Builder ipv4Enabled(com.hashicorp.cdktf.IResolvable ipv4Enabled) {
            this.ipv4Enabled = ipv4Enabled;
            return this;
        }

        /**
         * Sets the value of {@link ServerPublicNet#getIpv6}
         * @param ipv6 Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv6 Server#ipv6}.
         * @return {@code this}
         */
        public Builder ipv6(java.lang.Number ipv6) {
            this.ipv6 = ipv6;
            return this;
        }

        /**
         * Sets the value of {@link ServerPublicNet#getIpv6Enabled}
         * @param ipv6Enabled Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv6_enabled Server#ipv6_enabled}.
         * @return {@code this}
         */
        public Builder ipv6Enabled(java.lang.Boolean ipv6Enabled) {
            this.ipv6Enabled = ipv6Enabled;
            return this;
        }

        /**
         * Sets the value of {@link ServerPublicNet#getIpv6Enabled}
         * @param ipv6Enabled Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ipv6_enabled Server#ipv6_enabled}.
         * @return {@code this}
         */
        public Builder ipv6Enabled(com.hashicorp.cdktf.IResolvable ipv6Enabled) {
            this.ipv6Enabled = ipv6Enabled;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServerPublicNet}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServerPublicNet build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link ServerPublicNet}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServerPublicNet {
        private final java.lang.Number ipv4;
        private final java.lang.Object ipv4Enabled;
        private final java.lang.Number ipv6;
        private final java.lang.Object ipv6Enabled;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.ipv4 = software.amazon.jsii.Kernel.get(this, "ipv4", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.ipv4Enabled = software.amazon.jsii.Kernel.get(this, "ipv4Enabled", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.ipv6 = software.amazon.jsii.Kernel.get(this, "ipv6", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.ipv6Enabled = software.amazon.jsii.Kernel.get(this, "ipv6Enabled", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.ipv4 = builder.ipv4;
            this.ipv4Enabled = builder.ipv4Enabled;
            this.ipv6 = builder.ipv6;
            this.ipv6Enabled = builder.ipv6Enabled;
        }

        @Override
        public final java.lang.Number getIpv4() {
            return this.ipv4;
        }

        @Override
        public final java.lang.Object getIpv4Enabled() {
            return this.ipv4Enabled;
        }

        @Override
        public final java.lang.Number getIpv6() {
            return this.ipv6;
        }

        @Override
        public final java.lang.Object getIpv6Enabled() {
            return this.ipv6Enabled;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getIpv4() != null) {
                data.set("ipv4", om.valueToTree(this.getIpv4()));
            }
            if (this.getIpv4Enabled() != null) {
                data.set("ipv4Enabled", om.valueToTree(this.getIpv4Enabled()));
            }
            if (this.getIpv6() != null) {
                data.set("ipv6", om.valueToTree(this.getIpv6()));
            }
            if (this.getIpv6Enabled() != null) {
                data.set("ipv6Enabled", om.valueToTree(this.getIpv6Enabled()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.server.ServerPublicNet"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerPublicNet.Jsii$Proxy that = (ServerPublicNet.Jsii$Proxy) o;

            if (this.ipv4 != null ? !this.ipv4.equals(that.ipv4) : that.ipv4 != null) return false;
            if (this.ipv4Enabled != null ? !this.ipv4Enabled.equals(that.ipv4Enabled) : that.ipv4Enabled != null) return false;
            if (this.ipv6 != null ? !this.ipv6.equals(that.ipv6) : that.ipv6 != null) return false;
            return this.ipv6Enabled != null ? this.ipv6Enabled.equals(that.ipv6Enabled) : that.ipv6Enabled == null;
        }

        @Override
        public final int hashCode() {
            int result = this.ipv4 != null ? this.ipv4.hashCode() : 0;
            result = 31 * result + (this.ipv4Enabled != null ? this.ipv4Enabled.hashCode() : 0);
            result = 31 * result + (this.ipv6 != null ? this.ipv6.hashCode() : 0);
            result = 31 * result + (this.ipv6Enabled != null ? this.ipv6Enabled.hashCode() : 0);
            return result;
        }
    }
}
