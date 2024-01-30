package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.341Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceHealthCheckHttp")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerServiceHealthCheckHttp.Jsii$Proxy.class)
public interface LoadBalancerServiceHealthCheckHttp extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#domain LoadBalancerService#domain}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getDomain() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#path LoadBalancerService#path}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPath() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#response LoadBalancerService#response}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getResponse() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#status_codes LoadBalancerService#status_codes}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getStatusCodes() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#tls LoadBalancerService#tls}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getTls() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerServiceHealthCheckHttp}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerServiceHealthCheckHttp}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerServiceHealthCheckHttp> {
        java.lang.String domain;
        java.lang.String path;
        java.lang.String response;
        java.util.List<java.lang.String> statusCodes;
        java.lang.Object tls;

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheckHttp#getDomain}
         * @param domain Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#domain LoadBalancerService#domain}.
         * @return {@code this}
         */
        public Builder domain(java.lang.String domain) {
            this.domain = domain;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheckHttp#getPath}
         * @param path Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#path LoadBalancerService#path}.
         * @return {@code this}
         */
        public Builder path(java.lang.String path) {
            this.path = path;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheckHttp#getResponse}
         * @param response Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#response LoadBalancerService#response}.
         * @return {@code this}
         */
        public Builder response(java.lang.String response) {
            this.response = response;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheckHttp#getStatusCodes}
         * @param statusCodes Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#status_codes LoadBalancerService#status_codes}.
         * @return {@code this}
         */
        public Builder statusCodes(java.util.List<java.lang.String> statusCodes) {
            this.statusCodes = statusCodes;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheckHttp#getTls}
         * @param tls Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#tls LoadBalancerService#tls}.
         * @return {@code this}
         */
        public Builder tls(java.lang.Boolean tls) {
            this.tls = tls;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheckHttp#getTls}
         * @param tls Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#tls LoadBalancerService#tls}.
         * @return {@code this}
         */
        public Builder tls(com.hashicorp.cdktf.IResolvable tls) {
            this.tls = tls;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link LoadBalancerServiceHealthCheckHttp}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerServiceHealthCheckHttp build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerServiceHealthCheckHttp}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerServiceHealthCheckHttp {
        private final java.lang.String domain;
        private final java.lang.String path;
        private final java.lang.String response;
        private final java.util.List<java.lang.String> statusCodes;
        private final java.lang.Object tls;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.domain = software.amazon.jsii.Kernel.get(this, "domain", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.path = software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.response = software.amazon.jsii.Kernel.get(this, "response", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.statusCodes = software.amazon.jsii.Kernel.get(this, "statusCodes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.tls = software.amazon.jsii.Kernel.get(this, "tls", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.domain = builder.domain;
            this.path = builder.path;
            this.response = builder.response;
            this.statusCodes = builder.statusCodes;
            this.tls = builder.tls;
        }

        @Override
        public final java.lang.String getDomain() {
            return this.domain;
        }

        @Override
        public final java.lang.String getPath() {
            return this.path;
        }

        @Override
        public final java.lang.String getResponse() {
            return this.response;
        }

        @Override
        public final java.util.List<java.lang.String> getStatusCodes() {
            return this.statusCodes;
        }

        @Override
        public final java.lang.Object getTls() {
            return this.tls;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getDomain() != null) {
                data.set("domain", om.valueToTree(this.getDomain()));
            }
            if (this.getPath() != null) {
                data.set("path", om.valueToTree(this.getPath()));
            }
            if (this.getResponse() != null) {
                data.set("response", om.valueToTree(this.getResponse()));
            }
            if (this.getStatusCodes() != null) {
                data.set("statusCodes", om.valueToTree(this.getStatusCodes()));
            }
            if (this.getTls() != null) {
                data.set("tls", om.valueToTree(this.getTls()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.loadBalancerService.LoadBalancerServiceHealthCheckHttp"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerServiceHealthCheckHttp.Jsii$Proxy that = (LoadBalancerServiceHealthCheckHttp.Jsii$Proxy) o;

            if (this.domain != null ? !this.domain.equals(that.domain) : that.domain != null) return false;
            if (this.path != null ? !this.path.equals(that.path) : that.path != null) return false;
            if (this.response != null ? !this.response.equals(that.response) : that.response != null) return false;
            if (this.statusCodes != null ? !this.statusCodes.equals(that.statusCodes) : that.statusCodes != null) return false;
            return this.tls != null ? this.tls.equals(that.tls) : that.tls == null;
        }

        @Override
        public final int hashCode() {
            int result = this.domain != null ? this.domain.hashCode() : 0;
            result = 31 * result + (this.path != null ? this.path.hashCode() : 0);
            result = 31 * result + (this.response != null ? this.response.hashCode() : 0);
            result = 31 * result + (this.statusCodes != null ? this.statusCodes.hashCode() : 0);
            result = 31 * result + (this.tls != null ? this.tls.hashCode() : 0);
            return result;
        }
    }
}
