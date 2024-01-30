package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.network;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.345Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.network.NetworkConfig")
@software.amazon.jsii.Jsii.Proxy(NetworkConfig.Jsii$Proxy.class)
public interface NetworkConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#ip_range Network#ip_range}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getIpRange();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#name Network#name}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#delete_protection Network#delete_protection}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getDeleteProtection() {
        return null;
    }

    /**
     * Enable or disable exposing the routes to the vSwitch connection.
     * <p>
     * The exposing only takes effect if a vSwitch connection is active.
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#expose_routes_to_vswitch Network#expose_routes_to_vswitch}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getExposeRoutesToVswitch() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#id Network#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#labels Network#labels}.
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getLabels() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link NetworkConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link NetworkConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<NetworkConfig> {
        java.lang.String ipRange;
        java.lang.String name;
        java.lang.Object deleteProtection;
        java.lang.Object exposeRoutesToVswitch;
        java.lang.String id;
        java.util.Map<java.lang.String, java.lang.String> labels;
        java.lang.Object connection;
        java.lang.Object count;
        java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        com.hashicorp.cdktf.ITerraformIterator forEach;
        com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        com.hashicorp.cdktf.TerraformProvider provider;
        java.util.List<java.lang.Object> provisioners;

        /**
         * Sets the value of {@link NetworkConfig#getIpRange}
         * @param ipRange Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#ip_range Network#ip_range}. This parameter is required.
         * @return {@code this}
         */
        public Builder ipRange(java.lang.String ipRange) {
            this.ipRange = ipRange;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getName}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#name Network#name}. This parameter is required.
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getDeleteProtection}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#delete_protection Network#delete_protection}.
         * @return {@code this}
         */
        public Builder deleteProtection(java.lang.Boolean deleteProtection) {
            this.deleteProtection = deleteProtection;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getDeleteProtection}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#delete_protection Network#delete_protection}.
         * @return {@code this}
         */
        public Builder deleteProtection(com.hashicorp.cdktf.IResolvable deleteProtection) {
            this.deleteProtection = deleteProtection;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getExposeRoutesToVswitch}
         * @param exposeRoutesToVswitch Enable or disable exposing the routes to the vSwitch connection.
         *                              The exposing only takes effect if a vSwitch connection is active.
         *                              
         *                              Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#expose_routes_to_vswitch Network#expose_routes_to_vswitch}
         * @return {@code this}
         */
        public Builder exposeRoutesToVswitch(java.lang.Boolean exposeRoutesToVswitch) {
            this.exposeRoutesToVswitch = exposeRoutesToVswitch;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getExposeRoutesToVswitch}
         * @param exposeRoutesToVswitch Enable or disable exposing the routes to the vSwitch connection.
         *                              The exposing only takes effect if a vSwitch connection is active.
         *                              
         *                              Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#expose_routes_to_vswitch Network#expose_routes_to_vswitch}
         * @return {@code this}
         */
        public Builder exposeRoutesToVswitch(com.hashicorp.cdktf.IResolvable exposeRoutesToVswitch) {
            this.exposeRoutesToVswitch = exposeRoutesToVswitch;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#id Network#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getLabels}
         * @param labels Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/network#labels Network#labels}.
         * @return {@code this}
         */
        public Builder labels(java.util.Map<java.lang.String, java.lang.String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getDependsOn}
         * @param dependsOn the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder dependsOn(java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link NetworkConfig#getProvisioners}
         * @param provisioners the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder provisioners(java.util.List<? extends java.lang.Object> provisioners) {
            this.provisioners = (java.util.List<java.lang.Object>)provisioners;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link NetworkConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public NetworkConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link NetworkConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements NetworkConfig {
        private final java.lang.String ipRange;
        private final java.lang.String name;
        private final java.lang.Object deleteProtection;
        private final java.lang.Object exposeRoutesToVswitch;
        private final java.lang.String id;
        private final java.util.Map<java.lang.String, java.lang.String> labels;
        private final java.lang.Object connection;
        private final java.lang.Object count;
        private final java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private final com.hashicorp.cdktf.ITerraformIterator forEach;
        private final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private final com.hashicorp.cdktf.TerraformProvider provider;
        private final java.util.List<java.lang.Object> provisioners;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.ipRange = software.amazon.jsii.Kernel.get(this, "ipRange", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.deleteProtection = software.amazon.jsii.Kernel.get(this, "deleteProtection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.exposeRoutesToVswitch = software.amazon.jsii.Kernel.get(this, "exposeRoutesToVswitch", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.labels = software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.connection = software.amazon.jsii.Kernel.get(this, "connection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.count = software.amazon.jsii.Kernel.get(this, "count", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.dependsOn = software.amazon.jsii.Kernel.get(this, "dependsOn", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformDependable.class)));
            this.forEach = software.amazon.jsii.Kernel.get(this, "forEach", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformIterator.class));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformResourceLifecycle.class));
            this.provider = software.amazon.jsii.Kernel.get(this, "provider", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformProvider.class));
            this.provisioners = software.amazon.jsii.Kernel.get(this, "provisioners", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.ipRange = java.util.Objects.requireNonNull(builder.ipRange, "ipRange is required");
            this.name = java.util.Objects.requireNonNull(builder.name, "name is required");
            this.deleteProtection = builder.deleteProtection;
            this.exposeRoutesToVswitch = builder.exposeRoutesToVswitch;
            this.id = builder.id;
            this.labels = builder.labels;
            this.connection = builder.connection;
            this.count = builder.count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)builder.dependsOn;
            this.forEach = builder.forEach;
            this.lifecycle = builder.lifecycle;
            this.provider = builder.provider;
            this.provisioners = (java.util.List<java.lang.Object>)builder.provisioners;
        }

        @Override
        public final java.lang.String getIpRange() {
            return this.ipRange;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.Object getDeleteProtection() {
            return this.deleteProtection;
        }

        @Override
        public final java.lang.Object getExposeRoutesToVswitch() {
            return this.exposeRoutesToVswitch;
        }

        @Override
        public final java.lang.String getId() {
            return this.id;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getLabels() {
            return this.labels;
        }

        @Override
        public final java.lang.Object getConnection() {
            return this.connection;
        }

        @Override
        public final java.lang.Object getCount() {
            return this.count;
        }

        @Override
        public final java.util.List<com.hashicorp.cdktf.ITerraformDependable> getDependsOn() {
            return this.dependsOn;
        }

        @Override
        public final com.hashicorp.cdktf.ITerraformIterator getForEach() {
            return this.forEach;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformResourceLifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformProvider getProvider() {
            return this.provider;
        }

        @Override
        public final java.util.List<java.lang.Object> getProvisioners() {
            return this.provisioners;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("ipRange", om.valueToTree(this.getIpRange()));
            data.set("name", om.valueToTree(this.getName()));
            if (this.getDeleteProtection() != null) {
                data.set("deleteProtection", om.valueToTree(this.getDeleteProtection()));
            }
            if (this.getExposeRoutesToVswitch() != null) {
                data.set("exposeRoutesToVswitch", om.valueToTree(this.getExposeRoutesToVswitch()));
            }
            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getLabels() != null) {
                data.set("labels", om.valueToTree(this.getLabels()));
            }
            if (this.getConnection() != null) {
                data.set("connection", om.valueToTree(this.getConnection()));
            }
            if (this.getCount() != null) {
                data.set("count", om.valueToTree(this.getCount()));
            }
            if (this.getDependsOn() != null) {
                data.set("dependsOn", om.valueToTree(this.getDependsOn()));
            }
            if (this.getForEach() != null) {
                data.set("forEach", om.valueToTree(this.getForEach()));
            }
            if (this.getLifecycle() != null) {
                data.set("lifecycle", om.valueToTree(this.getLifecycle()));
            }
            if (this.getProvider() != null) {
                data.set("provider", om.valueToTree(this.getProvider()));
            }
            if (this.getProvisioners() != null) {
                data.set("provisioners", om.valueToTree(this.getProvisioners()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.network.NetworkConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NetworkConfig.Jsii$Proxy that = (NetworkConfig.Jsii$Proxy) o;

            if (!ipRange.equals(that.ipRange)) return false;
            if (!name.equals(that.name)) return false;
            if (this.deleteProtection != null ? !this.deleteProtection.equals(that.deleteProtection) : that.deleteProtection != null) return false;
            if (this.exposeRoutesToVswitch != null ? !this.exposeRoutesToVswitch.equals(that.exposeRoutesToVswitch) : that.exposeRoutesToVswitch != null) return false;
            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            if (this.labels != null ? !this.labels.equals(that.labels) : that.labels != null) return false;
            if (this.connection != null ? !this.connection.equals(that.connection) : that.connection != null) return false;
            if (this.count != null ? !this.count.equals(that.count) : that.count != null) return false;
            if (this.dependsOn != null ? !this.dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
            if (this.forEach != null ? !this.forEach.equals(that.forEach) : that.forEach != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            if (this.provider != null ? !this.provider.equals(that.provider) : that.provider != null) return false;
            return this.provisioners != null ? this.provisioners.equals(that.provisioners) : that.provisioners == null;
        }

        @Override
        public final int hashCode() {
            int result = this.ipRange.hashCode();
            result = 31 * result + (this.name.hashCode());
            result = 31 * result + (this.deleteProtection != null ? this.deleteProtection.hashCode() : 0);
            result = 31 * result + (this.exposeRoutesToVswitch != null ? this.exposeRoutesToVswitch.hashCode() : 0);
            result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
            result = 31 * result + (this.labels != null ? this.labels.hashCode() : 0);
            result = 31 * result + (this.connection != null ? this.connection.hashCode() : 0);
            result = 31 * result + (this.count != null ? this.count.hashCode() : 0);
            result = 31 * result + (this.dependsOn != null ? this.dependsOn.hashCode() : 0);
            result = 31 * result + (this.forEach != null ? this.forEach.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.provider != null ? this.provider.hashCode() : 0);
            result = 31 * result + (this.provisioners != null ? this.provisioners.hashCode() : 0);
            return result;
        }
    }
}
