package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.361Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.server.ServerTimeouts")
@software.amazon.jsii.Jsii.Proxy(ServerTimeouts.Jsii$Proxy.class)
public interface ServerTimeouts extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#create Server#create}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getCreate() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServerTimeouts}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServerTimeouts}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServerTimeouts> {
        java.lang.String create;

        /**
         * Sets the value of {@link ServerTimeouts#getCreate}
         * @param create Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#create Server#create}.
         * @return {@code this}
         */
        public Builder create(java.lang.String create) {
            this.create = create;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServerTimeouts}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServerTimeouts build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link ServerTimeouts}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServerTimeouts {
        private final java.lang.String create;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.create = software.amazon.jsii.Kernel.get(this, "create", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.create = builder.create;
        }

        @Override
        public final java.lang.String getCreate() {
            return this.create;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getCreate() != null) {
                data.set("create", om.valueToTree(this.getCreate()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.server.ServerTimeouts"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServerTimeouts.Jsii$Proxy that = (ServerTimeouts.Jsii$Proxy) o;

            return this.create != null ? this.create.equals(that.create) : that.create == null;
        }

        @Override
        public final int hashCode() {
            int result = this.create != null ? this.create.hashCode() : 0;
            return result;
        }
    }
}
