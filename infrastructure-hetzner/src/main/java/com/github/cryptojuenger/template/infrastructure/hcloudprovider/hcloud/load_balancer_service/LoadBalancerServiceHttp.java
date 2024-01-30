package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.342Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceHttp")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerServiceHttp.Jsii$Proxy.class)
public interface LoadBalancerServiceHttp extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#certificates LoadBalancerService#certificates}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.Number> getCertificates() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#cookie_lifetime LoadBalancerService#cookie_lifetime}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getCookieLifetime() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#cookie_name LoadBalancerService#cookie_name}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getCookieName() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#redirect_http LoadBalancerService#redirect_http}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getRedirectHttp() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#sticky_sessions LoadBalancerService#sticky_sessions}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getStickySessions() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerServiceHttp}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerServiceHttp}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerServiceHttp> {
        java.util.List<java.lang.Number> certificates;
        java.lang.Number cookieLifetime;
        java.lang.String cookieName;
        java.lang.Object redirectHttp;
        java.lang.Object stickySessions;

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getCertificates}
         * @param certificates Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#certificates LoadBalancerService#certificates}.
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder certificates(java.util.List<? extends java.lang.Number> certificates) {
            this.certificates = (java.util.List<java.lang.Number>)certificates;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getCookieLifetime}
         * @param cookieLifetime Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#cookie_lifetime LoadBalancerService#cookie_lifetime}.
         * @return {@code this}
         */
        public Builder cookieLifetime(java.lang.Number cookieLifetime) {
            this.cookieLifetime = cookieLifetime;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getCookieName}
         * @param cookieName Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#cookie_name LoadBalancerService#cookie_name}.
         * @return {@code this}
         */
        public Builder cookieName(java.lang.String cookieName) {
            this.cookieName = cookieName;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getRedirectHttp}
         * @param redirectHttp Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#redirect_http LoadBalancerService#redirect_http}.
         * @return {@code this}
         */
        public Builder redirectHttp(java.lang.Boolean redirectHttp) {
            this.redirectHttp = redirectHttp;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getRedirectHttp}
         * @param redirectHttp Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#redirect_http LoadBalancerService#redirect_http}.
         * @return {@code this}
         */
        public Builder redirectHttp(com.hashicorp.cdktf.IResolvable redirectHttp) {
            this.redirectHttp = redirectHttp;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getStickySessions}
         * @param stickySessions Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#sticky_sessions LoadBalancerService#sticky_sessions}.
         * @return {@code this}
         */
        public Builder stickySessions(java.lang.Boolean stickySessions) {
            this.stickySessions = stickySessions;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHttp#getStickySessions}
         * @param stickySessions Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#sticky_sessions LoadBalancerService#sticky_sessions}.
         * @return {@code this}
         */
        public Builder stickySessions(com.hashicorp.cdktf.IResolvable stickySessions) {
            this.stickySessions = stickySessions;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link LoadBalancerServiceHttp}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerServiceHttp build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerServiceHttp}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerServiceHttp {
        private final java.util.List<java.lang.Number> certificates;
        private final java.lang.Number cookieLifetime;
        private final java.lang.String cookieName;
        private final java.lang.Object redirectHttp;
        private final java.lang.Object stickySessions;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.certificates = software.amazon.jsii.Kernel.get(this, "certificates", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class)));
            this.cookieLifetime = software.amazon.jsii.Kernel.get(this, "cookieLifetime", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.cookieName = software.amazon.jsii.Kernel.get(this, "cookieName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.redirectHttp = software.amazon.jsii.Kernel.get(this, "redirectHttp", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.stickySessions = software.amazon.jsii.Kernel.get(this, "stickySessions", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.certificates = (java.util.List<java.lang.Number>)builder.certificates;
            this.cookieLifetime = builder.cookieLifetime;
            this.cookieName = builder.cookieName;
            this.redirectHttp = builder.redirectHttp;
            this.stickySessions = builder.stickySessions;
        }

        @Override
        public final java.util.List<java.lang.Number> getCertificates() {
            return this.certificates;
        }

        @Override
        public final java.lang.Number getCookieLifetime() {
            return this.cookieLifetime;
        }

        @Override
        public final java.lang.String getCookieName() {
            return this.cookieName;
        }

        @Override
        public final java.lang.Object getRedirectHttp() {
            return this.redirectHttp;
        }

        @Override
        public final java.lang.Object getStickySessions() {
            return this.stickySessions;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getCertificates() != null) {
                data.set("certificates", om.valueToTree(this.getCertificates()));
            }
            if (this.getCookieLifetime() != null) {
                data.set("cookieLifetime", om.valueToTree(this.getCookieLifetime()));
            }
            if (this.getCookieName() != null) {
                data.set("cookieName", om.valueToTree(this.getCookieName()));
            }
            if (this.getRedirectHttp() != null) {
                data.set("redirectHttp", om.valueToTree(this.getRedirectHttp()));
            }
            if (this.getStickySessions() != null) {
                data.set("stickySessions", om.valueToTree(this.getStickySessions()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.loadBalancerService.LoadBalancerServiceHttp"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerServiceHttp.Jsii$Proxy that = (LoadBalancerServiceHttp.Jsii$Proxy) o;

            if (this.certificates != null ? !this.certificates.equals(that.certificates) : that.certificates != null) return false;
            if (this.cookieLifetime != null ? !this.cookieLifetime.equals(that.cookieLifetime) : that.cookieLifetime != null) return false;
            if (this.cookieName != null ? !this.cookieName.equals(that.cookieName) : that.cookieName != null) return false;
            if (this.redirectHttp != null ? !this.redirectHttp.equals(that.redirectHttp) : that.redirectHttp != null) return false;
            return this.stickySessions != null ? this.stickySessions.equals(that.stickySessions) : that.stickySessions == null;
        }

        @Override
        public final int hashCode() {
            int result = this.certificates != null ? this.certificates.hashCode() : 0;
            result = 31 * result + (this.cookieLifetime != null ? this.cookieLifetime.hashCode() : 0);
            result = 31 * result + (this.cookieName != null ? this.cookieName.hashCode() : 0);
            result = 31 * result + (this.redirectHttp != null ? this.redirectHttp.hashCode() : 0);
            result = 31 * result + (this.stickySessions != null ? this.stickySessions.hashCode() : 0);
            return result;
        }
    }
}
