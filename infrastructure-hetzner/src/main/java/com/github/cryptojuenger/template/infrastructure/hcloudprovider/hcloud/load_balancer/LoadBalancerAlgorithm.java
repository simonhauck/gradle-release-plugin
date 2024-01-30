package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.338Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancer.LoadBalancerAlgorithm")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerAlgorithm.Jsii$Proxy.class)
public interface LoadBalancerAlgorithm extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#type LoadBalancer#type}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getType() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerAlgorithm}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerAlgorithm}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerAlgorithm> {
        java.lang.String type;

        /**
         * Sets the value of {@link LoadBalancerAlgorithm#getType}
         * @param type Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#type LoadBalancer#type}.
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link LoadBalancerAlgorithm}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerAlgorithm build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerAlgorithm}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerAlgorithm {
        private final java.lang.String type;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.type = builder.type;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getType() != null) {
                data.set("type", om.valueToTree(this.getType()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.loadBalancer.LoadBalancerAlgorithm"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerAlgorithm.Jsii$Proxy that = (LoadBalancerAlgorithm.Jsii$Proxy) o;

            return this.type != null ? this.type.equals(that.type) : that.type == null;
        }

        @Override
        public final int hashCode() {
            int result = this.type != null ? this.type.hashCode() : 0;
            return result;
        }
    }
}
