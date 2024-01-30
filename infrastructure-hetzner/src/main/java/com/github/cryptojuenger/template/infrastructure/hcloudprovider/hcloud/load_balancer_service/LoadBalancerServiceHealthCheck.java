package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.341Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceHealthCheck")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerServiceHealthCheck.Jsii$Proxy.class)
public interface LoadBalancerServiceHealthCheck extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#interval LoadBalancerService#interval}.
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getInterval();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#port LoadBalancerService#port}.
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getPort();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#protocol LoadBalancerService#protocol}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getProtocol();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#timeout LoadBalancerService#timeout}.
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getTimeout();

    /**
     * http block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#http LoadBalancerService#http}
     */
    default @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp getHttp() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#retries LoadBalancerService#retries}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRetries() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerServiceHealthCheck}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerServiceHealthCheck}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerServiceHealthCheck> {
        java.lang.Number interval;
        java.lang.Number port;
        java.lang.String protocol;
        java.lang.Number timeout;
        com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp http;
        java.lang.Number retries;

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheck#getInterval}
         * @param interval Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#interval LoadBalancerService#interval}. This parameter is required.
         * @return {@code this}
         */
        public Builder interval(java.lang.Number interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheck#getPort}
         * @param port Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#port LoadBalancerService#port}. This parameter is required.
         * @return {@code this}
         */
        public Builder port(java.lang.Number port) {
            this.port = port;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheck#getProtocol}
         * @param protocol Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#protocol LoadBalancerService#protocol}. This parameter is required.
         * @return {@code this}
         */
        public Builder protocol(java.lang.String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheck#getTimeout}
         * @param timeout Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#timeout LoadBalancerService#timeout}. This parameter is required.
         * @return {@code this}
         */
        public Builder timeout(java.lang.Number timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheck#getHttp}
         * @param http http block.
         *             Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#http LoadBalancerService#http}
         * @return {@code this}
         */
        public Builder http(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp http) {
            this.http = http;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerServiceHealthCheck#getRetries}
         * @param retries Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer_service#retries LoadBalancerService#retries}.
         * @return {@code this}
         */
        public Builder retries(java.lang.Number retries) {
            this.retries = retries;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link LoadBalancerServiceHealthCheck}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerServiceHealthCheck build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerServiceHealthCheck}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerServiceHealthCheck {
        private final java.lang.Number interval;
        private final java.lang.Number port;
        private final java.lang.String protocol;
        private final java.lang.Number timeout;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp http;
        private final java.lang.Number retries;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.interval = software.amazon.jsii.Kernel.get(this, "interval", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.protocol = software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.timeout = software.amazon.jsii.Kernel.get(this, "timeout", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.http = software.amazon.jsii.Kernel.get(this, "http", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp.class));
            this.retries = software.amazon.jsii.Kernel.get(this, "retries", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.interval = java.util.Objects.requireNonNull(builder.interval, "interval is required");
            this.port = java.util.Objects.requireNonNull(builder.port, "port is required");
            this.protocol = java.util.Objects.requireNonNull(builder.protocol, "protocol is required");
            this.timeout = java.util.Objects.requireNonNull(builder.timeout, "timeout is required");
            this.http = builder.http;
            this.retries = builder.retries;
        }

        @Override
        public final java.lang.Number getInterval() {
            return this.interval;
        }

        @Override
        public final java.lang.Number getPort() {
            return this.port;
        }

        @Override
        public final java.lang.String getProtocol() {
            return this.protocol;
        }

        @Override
        public final java.lang.Number getTimeout() {
            return this.timeout;
        }

        @Override
        public final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp getHttp() {
            return this.http;
        }

        @Override
        public final java.lang.Number getRetries() {
            return this.retries;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("interval", om.valueToTree(this.getInterval()));
            data.set("port", om.valueToTree(this.getPort()));
            data.set("protocol", om.valueToTree(this.getProtocol()));
            data.set("timeout", om.valueToTree(this.getTimeout()));
            if (this.getHttp() != null) {
                data.set("http", om.valueToTree(this.getHttp()));
            }
            if (this.getRetries() != null) {
                data.set("retries", om.valueToTree(this.getRetries()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.loadBalancerService.LoadBalancerServiceHealthCheck"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerServiceHealthCheck.Jsii$Proxy that = (LoadBalancerServiceHealthCheck.Jsii$Proxy) o;

            if (!interval.equals(that.interval)) return false;
            if (!port.equals(that.port)) return false;
            if (!protocol.equals(that.protocol)) return false;
            if (!timeout.equals(that.timeout)) return false;
            if (this.http != null ? !this.http.equals(that.http) : that.http != null) return false;
            return this.retries != null ? this.retries.equals(that.retries) : that.retries == null;
        }

        @Override
        public final int hashCode() {
            int result = this.interval.hashCode();
            result = 31 * result + (this.port.hashCode());
            result = 31 * result + (this.protocol.hashCode());
            result = 31 * result + (this.timeout.hashCode());
            result = 31 * result + (this.http != null ? this.http.hashCode() : 0);
            result = 31 * result + (this.retries != null ? this.retries.hashCode() : 0);
            return result;
        }
    }
}
