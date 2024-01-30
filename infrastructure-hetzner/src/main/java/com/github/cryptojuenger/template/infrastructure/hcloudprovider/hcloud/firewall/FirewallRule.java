package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.333Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.firewall.FirewallRule")
@software.amazon.jsii.Jsii.Proxy(FirewallRule.Jsii$Proxy.class)
public interface FirewallRule extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#direction Firewall#direction}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getDirection();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#protocol Firewall#protocol}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getProtocol();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#description Firewall#description}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getDescription() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#destination_ips Firewall#destination_ips}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getDestinationIps() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#port Firewall#port}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPort() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#source_ips Firewall#source_ips}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getSourceIps() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link FirewallRule}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link FirewallRule}
     */
    public static final class Builder implements software.amazon.jsii.Builder<FirewallRule> {
        java.lang.String direction;
        java.lang.String protocol;
        java.lang.String description;
        java.util.List<java.lang.String> destinationIps;
        java.lang.String port;
        java.util.List<java.lang.String> sourceIps;

        /**
         * Sets the value of {@link FirewallRule#getDirection}
         * @param direction Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#direction Firewall#direction}. This parameter is required.
         * @return {@code this}
         */
        public Builder direction(java.lang.String direction) {
            this.direction = direction;
            return this;
        }

        /**
         * Sets the value of {@link FirewallRule#getProtocol}
         * @param protocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#protocol Firewall#protocol}. This parameter is required.
         * @return {@code this}
         */
        public Builder protocol(java.lang.String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Sets the value of {@link FirewallRule#getDescription}
         * @param description Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#description Firewall#description}.
         * @return {@code this}
         */
        public Builder description(java.lang.String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the value of {@link FirewallRule#getDestinationIps}
         * @param destinationIps Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#destination_ips Firewall#destination_ips}.
         * @return {@code this}
         */
        public Builder destinationIps(java.util.List<java.lang.String> destinationIps) {
            this.destinationIps = destinationIps;
            return this;
        }

        /**
         * Sets the value of {@link FirewallRule#getPort}
         * @param port Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#port Firewall#port}.
         * @return {@code this}
         */
        public Builder port(java.lang.String port) {
            this.port = port;
            return this;
        }

        /**
         * Sets the value of {@link FirewallRule#getSourceIps}
         * @param sourceIps Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall#source_ips Firewall#source_ips}.
         * @return {@code this}
         */
        public Builder sourceIps(java.util.List<java.lang.String> sourceIps) {
            this.sourceIps = sourceIps;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link FirewallRule}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public FirewallRule build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link FirewallRule}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements FirewallRule {
        private final java.lang.String direction;
        private final java.lang.String protocol;
        private final java.lang.String description;
        private final java.util.List<java.lang.String> destinationIps;
        private final java.lang.String port;
        private final java.util.List<java.lang.String> sourceIps;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.direction = software.amazon.jsii.Kernel.get(this, "direction", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.protocol = software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.description = software.amazon.jsii.Kernel.get(this, "description", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.destinationIps = software.amazon.jsii.Kernel.get(this, "destinationIps", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.sourceIps = software.amazon.jsii.Kernel.get(this, "sourceIps", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.direction = java.util.Objects.requireNonNull(builder.direction, "direction is required");
            this.protocol = java.util.Objects.requireNonNull(builder.protocol, "protocol is required");
            this.description = builder.description;
            this.destinationIps = builder.destinationIps;
            this.port = builder.port;
            this.sourceIps = builder.sourceIps;
        }

        @Override
        public final java.lang.String getDirection() {
            return this.direction;
        }

        @Override
        public final java.lang.String getProtocol() {
            return this.protocol;
        }

        @Override
        public final java.lang.String getDescription() {
            return this.description;
        }

        @Override
        public final java.util.List<java.lang.String> getDestinationIps() {
            return this.destinationIps;
        }

        @Override
        public final java.lang.String getPort() {
            return this.port;
        }

        @Override
        public final java.util.List<java.lang.String> getSourceIps() {
            return this.sourceIps;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("direction", om.valueToTree(this.getDirection()));
            data.set("protocol", om.valueToTree(this.getProtocol()));
            if (this.getDescription() != null) {
                data.set("description", om.valueToTree(this.getDescription()));
            }
            if (this.getDestinationIps() != null) {
                data.set("destinationIps", om.valueToTree(this.getDestinationIps()));
            }
            if (this.getPort() != null) {
                data.set("port", om.valueToTree(this.getPort()));
            }
            if (this.getSourceIps() != null) {
                data.set("sourceIps", om.valueToTree(this.getSourceIps()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.firewall.FirewallRule"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FirewallRule.Jsii$Proxy that = (FirewallRule.Jsii$Proxy) o;

            if (!direction.equals(that.direction)) return false;
            if (!protocol.equals(that.protocol)) return false;
            if (this.description != null ? !this.description.equals(that.description) : that.description != null) return false;
            if (this.destinationIps != null ? !this.destinationIps.equals(that.destinationIps) : that.destinationIps != null) return false;
            if (this.port != null ? !this.port.equals(that.port) : that.port != null) return false;
            return this.sourceIps != null ? this.sourceIps.equals(that.sourceIps) : that.sourceIps == null;
        }

        @Override
        public final int hashCode() {
            int result = this.direction.hashCode();
            result = 31 * result + (this.protocol.hashCode());
            result = 31 * result + (this.description != null ? this.description.hashCode() : 0);
            result = 31 * result + (this.destinationIps != null ? this.destinationIps.hashCode() : 0);
            result = 31 * result + (this.port != null ? this.port.hashCode() : 0);
            result = 31 * result + (this.sourceIps != null ? this.sourceIps.hashCode() : 0);
            return result;
        }
    }
}
