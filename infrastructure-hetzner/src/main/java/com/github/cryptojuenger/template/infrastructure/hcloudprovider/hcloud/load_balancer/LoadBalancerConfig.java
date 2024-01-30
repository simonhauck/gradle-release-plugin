package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.338Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancer.LoadBalancerConfig")
@software.amazon.jsii.Jsii.Proxy(LoadBalancerConfig.Jsii$Proxy.class)
public interface LoadBalancerConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#load_balancer_type LoadBalancer#load_balancer_type}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getLoadBalancerType();

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#name LoadBalancer#name}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * algorithm block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#algorithm LoadBalancer#algorithm}
     */
    default @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm getAlgorithm() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getDeleteProtection() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#id LoadBalancer#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#labels LoadBalancer#labels}.
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getLabels() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#location LoadBalancer#location}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getLocation() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#network_zone LoadBalancer#network_zone}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getNetworkZone() {
        return null;
    }

    /**
     * target block.
     * <p>
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#target LoadBalancer#target}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getTarget() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LoadBalancerConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LoadBalancerConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LoadBalancerConfig> {
        java.lang.String loadBalancerType;
        java.lang.String name;
        com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm algorithm;
        java.lang.Object deleteProtection;
        java.lang.String id;
        java.util.Map<java.lang.String, java.lang.String> labels;
        java.lang.String location;
        java.lang.String networkZone;
        java.lang.Object target;
        java.lang.Object connection;
        java.lang.Object count;
        java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        com.hashicorp.cdktf.ITerraformIterator forEach;
        com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        com.hashicorp.cdktf.TerraformProvider provider;
        java.util.List<java.lang.Object> provisioners;

        /**
         * Sets the value of {@link LoadBalancerConfig#getLoadBalancerType}
         * @param loadBalancerType Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#load_balancer_type LoadBalancer#load_balancer_type}. This parameter is required.
         * @return {@code this}
         */
        public Builder loadBalancerType(java.lang.String loadBalancerType) {
            this.loadBalancerType = loadBalancerType;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getName}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#name LoadBalancer#name}. This parameter is required.
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getAlgorithm}
         * @param algorithm algorithm block.
         *                  Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#algorithm LoadBalancer#algorithm}
         * @return {@code this}
         */
        public Builder algorithm(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getDeleteProtection}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}.
         * @return {@code this}
         */
        public Builder deleteProtection(java.lang.Boolean deleteProtection) {
            this.deleteProtection = deleteProtection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getDeleteProtection}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}.
         * @return {@code this}
         */
        public Builder deleteProtection(com.hashicorp.cdktf.IResolvable deleteProtection) {
            this.deleteProtection = deleteProtection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#id LoadBalancer#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getLabels}
         * @param labels Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#labels LoadBalancer#labels}.
         * @return {@code this}
         */
        public Builder labels(java.util.Map<java.lang.String, java.lang.String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getLocation}
         * @param location Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#location LoadBalancer#location}.
         * @return {@code this}
         */
        public Builder location(java.lang.String location) {
            this.location = location;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getNetworkZone}
         * @param networkZone Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#network_zone LoadBalancer#network_zone}.
         * @return {@code this}
         */
        public Builder networkZone(java.lang.String networkZone) {
            this.networkZone = networkZone;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getTarget}
         * @param target target block.
         *               Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#target LoadBalancer#target}
         * @return {@code this}
         */
        public Builder target(com.hashicorp.cdktf.IResolvable target) {
            this.target = target;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getTarget}
         * @param target target block.
         *               Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#target LoadBalancer#target}
         * @return {@code this}
         */
        public Builder target(java.util.List<? extends com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTarget> target) {
            this.target = target;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getDependsOn}
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
         * Sets the value of {@link LoadBalancerConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link LoadBalancerConfig#getProvisioners}
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
         * @return a new instance of {@link LoadBalancerConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LoadBalancerConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link LoadBalancerConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LoadBalancerConfig {
        private final java.lang.String loadBalancerType;
        private final java.lang.String name;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm algorithm;
        private final java.lang.Object deleteProtection;
        private final java.lang.String id;
        private final java.util.Map<java.lang.String, java.lang.String> labels;
        private final java.lang.String location;
        private final java.lang.String networkZone;
        private final java.lang.Object target;
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
            this.loadBalancerType = software.amazon.jsii.Kernel.get(this, "loadBalancerType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.algorithm = software.amazon.jsii.Kernel.get(this, "algorithm", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm.class));
            this.deleteProtection = software.amazon.jsii.Kernel.get(this, "deleteProtection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.labels = software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.location = software.amazon.jsii.Kernel.get(this, "location", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.networkZone = software.amazon.jsii.Kernel.get(this, "networkZone", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.target = software.amazon.jsii.Kernel.get(this, "target", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
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
            this.loadBalancerType = java.util.Objects.requireNonNull(builder.loadBalancerType, "loadBalancerType is required");
            this.name = java.util.Objects.requireNonNull(builder.name, "name is required");
            this.algorithm = builder.algorithm;
            this.deleteProtection = builder.deleteProtection;
            this.id = builder.id;
            this.labels = builder.labels;
            this.location = builder.location;
            this.networkZone = builder.networkZone;
            this.target = builder.target;
            this.connection = builder.connection;
            this.count = builder.count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)builder.dependsOn;
            this.forEach = builder.forEach;
            this.lifecycle = builder.lifecycle;
            this.provider = builder.provider;
            this.provisioners = (java.util.List<java.lang.Object>)builder.provisioners;
        }

        @Override
        public final java.lang.String getLoadBalancerType() {
            return this.loadBalancerType;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm getAlgorithm() {
            return this.algorithm;
        }

        @Override
        public final java.lang.Object getDeleteProtection() {
            return this.deleteProtection;
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
        public final java.lang.String getLocation() {
            return this.location;
        }

        @Override
        public final java.lang.String getNetworkZone() {
            return this.networkZone;
        }

        @Override
        public final java.lang.Object getTarget() {
            return this.target;
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

            data.set("loadBalancerType", om.valueToTree(this.getLoadBalancerType()));
            data.set("name", om.valueToTree(this.getName()));
            if (this.getAlgorithm() != null) {
                data.set("algorithm", om.valueToTree(this.getAlgorithm()));
            }
            if (this.getDeleteProtection() != null) {
                data.set("deleteProtection", om.valueToTree(this.getDeleteProtection()));
            }
            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getLabels() != null) {
                data.set("labels", om.valueToTree(this.getLabels()));
            }
            if (this.getLocation() != null) {
                data.set("location", om.valueToTree(this.getLocation()));
            }
            if (this.getNetworkZone() != null) {
                data.set("networkZone", om.valueToTree(this.getNetworkZone()));
            }
            if (this.getTarget() != null) {
                data.set("target", om.valueToTree(this.getTarget()));
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
            struct.set("fqn", om.valueToTree("hcloud.loadBalancer.LoadBalancerConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LoadBalancerConfig.Jsii$Proxy that = (LoadBalancerConfig.Jsii$Proxy) o;

            if (!loadBalancerType.equals(that.loadBalancerType)) return false;
            if (!name.equals(that.name)) return false;
            if (this.algorithm != null ? !this.algorithm.equals(that.algorithm) : that.algorithm != null) return false;
            if (this.deleteProtection != null ? !this.deleteProtection.equals(that.deleteProtection) : that.deleteProtection != null) return false;
            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            if (this.labels != null ? !this.labels.equals(that.labels) : that.labels != null) return false;
            if (this.location != null ? !this.location.equals(that.location) : that.location != null) return false;
            if (this.networkZone != null ? !this.networkZone.equals(that.networkZone) : that.networkZone != null) return false;
            if (this.target != null ? !this.target.equals(that.target) : that.target != null) return false;
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
            int result = this.loadBalancerType.hashCode();
            result = 31 * result + (this.name.hashCode());
            result = 31 * result + (this.algorithm != null ? this.algorithm.hashCode() : 0);
            result = 31 * result + (this.deleteProtection != null ? this.deleteProtection.hashCode() : 0);
            result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
            result = 31 * result + (this.labels != null ? this.labels.hashCode() : 0);
            result = 31 * result + (this.location != null ? this.location.hashCode() : 0);
            result = 31 * result + (this.networkZone != null ? this.networkZone.hashCode() : 0);
            result = 31 * result + (this.target != null ? this.target.hashCode() : 0);
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
