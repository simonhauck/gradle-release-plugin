package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.332Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.firewall.FirewallApplyTo")
@software.amazon.jsii.Jsii.Proxy(FirewallApplyTo.Jsii$Proxy.class)
public interface FirewallApplyTo extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#label_selector Firewall#label_selector}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getLabelSelector() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#server Firewall#server}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getServer() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link FirewallApplyTo}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link FirewallApplyTo}
     */
    public static final class Builder implements software.amazon.jsii.Builder<FirewallApplyTo> {
        java.lang.String labelSelector;
        java.lang.Number server;

        /**
         * Sets the value of {@link FirewallApplyTo#getLabelSelector}
         * @param labelSelector Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#label_selector Firewall#label_selector}.
         * @return {@code this}
         */
        public Builder labelSelector(java.lang.String labelSelector) {
            this.labelSelector = labelSelector;
            return this;
        }

        /**
         * Sets the value of {@link FirewallApplyTo#getServer}
         * @param server Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#server Firewall#server}.
         * @return {@code this}
         */
        public Builder server(java.lang.Number server) {
            this.server = server;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link FirewallApplyTo}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public FirewallApplyTo build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link FirewallApplyTo}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements FirewallApplyTo {
        private final java.lang.String labelSelector;
        private final java.lang.Number server;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.labelSelector = software.amazon.jsii.Kernel.get(this, "labelSelector", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.server = software.amazon.jsii.Kernel.get(this, "server", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.labelSelector = builder.labelSelector;
            this.server = builder.server;
        }

        @Override
        public final java.lang.String getLabelSelector() {
            return this.labelSelector;
        }

        @Override
        public final java.lang.Number getServer() {
            return this.server;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getLabelSelector() != null) {
                data.set("labelSelector", om.valueToTree(this.getLabelSelector()));
            }
            if (this.getServer() != null) {
                data.set("server", om.valueToTree(this.getServer()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.firewall.FirewallApplyTo"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FirewallApplyTo.Jsii$Proxy that = (FirewallApplyTo.Jsii$Proxy) o;

            if (this.labelSelector != null ? !this.labelSelector.equals(that.labelSelector) : that.labelSelector != null) return false;
            return this.server != null ? this.server.equals(that.server) : that.server == null;
        }

        @Override
        public final int hashCode() {
            int result = this.labelSelector != null ? this.labelSelector.hashCode() : 0;
            result = 31 * result + (this.server != null ? this.server.hashCode() : 0);
            return result;
        }
    }
}