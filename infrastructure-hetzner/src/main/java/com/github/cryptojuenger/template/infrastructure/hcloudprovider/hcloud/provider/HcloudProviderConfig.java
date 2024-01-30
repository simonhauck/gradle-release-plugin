package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.356Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.provider.HcloudProviderConfig")
@software.amazon.jsii.Jsii.Proxy(HcloudProviderConfig.Jsii$Proxy.class)
public interface HcloudProviderConfig extends software.amazon.jsii.JsiiSerializable {

    /**
     * Alias name.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#alias HcloudProvider#alias}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getAlias() {
        return null;
    }

    /**
     * The Hetzner Cloud API endpoint, can be used to override the default API Endpoint https://api.hetzner.cloud/v1.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#endpoint HcloudProvider#endpoint}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getEndpoint() {
        return null;
    }

    /**
     * The type of function to be used during the polling.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#poll_function HcloudProvider#poll_function}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPollFunction() {
        return null;
    }

    /**
     * The interval at which actions are polled by the client.
     * <p>
     * Default `500ms`. Increase this interval if you run into rate limiting errors.
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#poll_interval HcloudProvider#poll_interval}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPollInterval() {
        return null;
    }

    /**
     * The Hetzner Cloud API token, can also be specified with the HCLOUD_TOKEN environment variable.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#token HcloudProvider#token}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getToken() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link HcloudProviderConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link HcloudProviderConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<HcloudProviderConfig> {
        java.lang.String alias;
        java.lang.String endpoint;
        java.lang.String pollFunction;
        java.lang.String pollInterval;
        java.lang.String token;

        /**
         * Sets the value of {@link HcloudProviderConfig#getAlias}
         * @param alias Alias name.
         *              Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#alias HcloudProvider#alias}
         * @return {@code this}
         */
        public Builder alias(java.lang.String alias) {
            this.alias = alias;
            return this;
        }

        /**
         * Sets the value of {@link HcloudProviderConfig#getEndpoint}
         * @param endpoint The Hetzner Cloud API endpoint, can be used to override the default API Endpoint https://api.hetzner.cloud/v1.
         *                 Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#endpoint HcloudProvider#endpoint}
         * @return {@code this}
         */
        public Builder endpoint(java.lang.String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        /**
         * Sets the value of {@link HcloudProviderConfig#getPollFunction}
         * @param pollFunction The type of function to be used during the polling.
         *                     Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#poll_function HcloudProvider#poll_function}
         * @return {@code this}
         */
        public Builder pollFunction(java.lang.String pollFunction) {
            this.pollFunction = pollFunction;
            return this;
        }

        /**
         * Sets the value of {@link HcloudProviderConfig#getPollInterval}
         * @param pollInterval The interval at which actions are polled by the client.
         *                     Default `500ms`. Increase this interval if you run into rate limiting errors.
         *                     
         *                     Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#poll_interval HcloudProvider#poll_interval}
         * @return {@code this}
         */
        public Builder pollInterval(java.lang.String pollInterval) {
            this.pollInterval = pollInterval;
            return this;
        }

        /**
         * Sets the value of {@link HcloudProviderConfig#getToken}
         * @param token The Hetzner Cloud API token, can also be specified with the HCLOUD_TOKEN environment variable.
         *              Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#token HcloudProvider#token}
         * @return {@code this}
         */
        public Builder token(java.lang.String token) {
            this.token = token;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link HcloudProviderConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public HcloudProviderConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link HcloudProviderConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements HcloudProviderConfig {
        private final java.lang.String alias;
        private final java.lang.String endpoint;
        private final java.lang.String pollFunction;
        private final java.lang.String pollInterval;
        private final java.lang.String token;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.alias = software.amazon.jsii.Kernel.get(this, "alias", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.endpoint = software.amazon.jsii.Kernel.get(this, "endpoint", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.pollFunction = software.amazon.jsii.Kernel.get(this, "pollFunction", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.pollInterval = software.amazon.jsii.Kernel.get(this, "pollInterval", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.token = software.amazon.jsii.Kernel.get(this, "token", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.alias = builder.alias;
            this.endpoint = builder.endpoint;
            this.pollFunction = builder.pollFunction;
            this.pollInterval = builder.pollInterval;
            this.token = builder.token;
        }

        @Override
        public final java.lang.String getAlias() {
            return this.alias;
        }

        @Override
        public final java.lang.String getEndpoint() {
            return this.endpoint;
        }

        @Override
        public final java.lang.String getPollFunction() {
            return this.pollFunction;
        }

        @Override
        public final java.lang.String getPollInterval() {
            return this.pollInterval;
        }

        @Override
        public final java.lang.String getToken() {
            return this.token;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getAlias() != null) {
                data.set("alias", om.valueToTree(this.getAlias()));
            }
            if (this.getEndpoint() != null) {
                data.set("endpoint", om.valueToTree(this.getEndpoint()));
            }
            if (this.getPollFunction() != null) {
                data.set("pollFunction", om.valueToTree(this.getPollFunction()));
            }
            if (this.getPollInterval() != null) {
                data.set("pollInterval", om.valueToTree(this.getPollInterval()));
            }
            if (this.getToken() != null) {
                data.set("token", om.valueToTree(this.getToken()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.provider.HcloudProviderConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HcloudProviderConfig.Jsii$Proxy that = (HcloudProviderConfig.Jsii$Proxy) o;

            if (this.alias != null ? !this.alias.equals(that.alias) : that.alias != null) return false;
            if (this.endpoint != null ? !this.endpoint.equals(that.endpoint) : that.endpoint != null) return false;
            if (this.pollFunction != null ? !this.pollFunction.equals(that.pollFunction) : that.pollFunction != null) return false;
            if (this.pollInterval != null ? !this.pollInterval.equals(that.pollInterval) : that.pollInterval != null) return false;
            return this.token != null ? this.token.equals(that.token) : that.token == null;
        }

        @Override
        public final int hashCode() {
            int result = this.alias != null ? this.alias.hashCode() : 0;
            result = 31 * result + (this.endpoint != null ? this.endpoint.hashCode() : 0);
            result = 31 * result + (this.pollFunction != null ? this.pollFunction.hashCode() : 0);
            result = 31 * result + (this.pollInterval != null ? this.pollInterval.hashCode() : 0);
            result = 31 * result + (this.token != null ? this.token.hashCode() : 0);
            return result;
        }
    }
}
