package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.338Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancer.LoadBalancerTarget")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerTarget.Jsii$Proxy.class)
public interface LoadBalancerTarget extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#type LoadBalancer#type}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getType();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#server_id LoadBalancer#server_id}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getServerId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#use_private_ip LoadBalancer#use_private_ip}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getUsePrivateIp() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerTarget}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerTarget}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerTarget> {
        java.lang.String type;
        java.lang.Number serverId;
        java.lang.Object usePrivateIp;

        /**
         * Sets the value of {@link LoadBalancerTarget#getType}
         * @param type Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#type LoadBalancer#type}. This parameter is required.
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerTarget#getServerId}
         * @param serverId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#server_id LoadBalancer#server_id}.
         * @return {@code this}
         */
        public Builder serverId(java.lang.Number serverId) {
            this.serverId = serverId;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerTarget#getUsePrivateIp}
         * @param usePrivateIp Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#use_private_ip LoadBalancer#use_private_ip}.
         * @return {@code this}
         */
        public Builder usePrivateIp(java.lang.Boolean usePrivateIp) {
            this.usePrivateIp = usePrivateIp;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerTarget#getUsePrivateIp}
         * @param usePrivateIp Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#use_private_ip LoadBalancer#use_private_ip}.
         * @return {@code this}
         */
        public Builder usePrivateIp(com.hashicorp.cdktf.IResolvable usePrivateIp) {
            this.usePrivateIp = usePrivateIp;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link LoadBalancerTarget}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerTarget build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerTarget}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerTarget {
        private final java.lang.String type;
        private final java.lang.Number serverId;
        private final java.lang.Object usePrivateIp;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.serverId = software.amazon.jsii.Kernel.get(this, "serverId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.usePrivateIp = software.amazon.jsii.Kernel.get(this, "usePrivateIp", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.type = java.util.Objects.requireNonNull(builder.type, "type is required");
            this.serverId = builder.serverId;
            this.usePrivateIp = builder.usePrivateIp;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
        }

        @Override
        public final java.lang.Number getServerId() {
            return this.serverId;
        }

        @Override
        public final java.lang.Object getUsePrivateIp() {
            return this.usePrivateIp;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("type", om.valueToTree(this.getType()));
            if (this.getServerId() != null) {
                data.set("serverId", om.valueToTree(this.getServerId()));
            }
            if (this.getUsePrivateIp() != null) {
                data.set("usePrivateIp", om.valueToTree(this.getUsePrivateIp()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.loadBalancer.LoadBalancerTarget"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerTarget.Jsii$Proxy that = (LoadBalancerTarget.Jsii$Proxy) o;

            if (!type.equals(that.type)) return false;
            if (this.serverId != null ? !this.serverId.equals(that.serverId) : that.serverId != null) return false;
            return this.usePrivateIp != null ? this.usePrivateIp.equals(that.usePrivateIp) : that.usePrivateIp == null;
        }

        @Override
        public final int hashCode() {
            int result = this.type.hashCode();
            result = 31 * result + (this.serverId != null ? this.serverId.hashCode() : 0);
            result = 31 * result + (this.usePrivateIp != null ? this.usePrivateIp.hashCode() : 0);
            return result;
        }
    }
}
