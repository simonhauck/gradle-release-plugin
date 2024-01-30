package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer hcloud_load_balancer}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.337Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancer.LoadBalancer")
public class LoadBalancer extends com.hashicorp.cdktf.TerraformResource {

    protected LoadBalancer(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected LoadBalancer(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer hcloud_load_balancer} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public LoadBalancer(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    /**
     * Generates CDKTF code for importing a LoadBalancer resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the LoadBalancer to import. This parameter is required.
     * @param importFromId The id of the existing LoadBalancer that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the LoadBalancer to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a LoadBalancer resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the LoadBalancer to import. This parameter is required.
     * @param importFromId The id of the existing LoadBalancer that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void putAlgorithm(final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm value) {
        software.amazon.jsii.Kernel.call(this, "putAlgorithm", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void putTarget(final @org.jetbrains.annotations.NotNull java.lang.Object value) {
        if (software.amazon.jsii.Configuration.getRuntimeTypeChecking()) {
            if (
                 !(value instanceof com.hashicorp.cdktf.IResolvable)
                && !(value instanceof java.util.List)
                && !(value.getClass().equals(software.amazon.jsii.JsiiObject.class))
            ) {
                throw new IllegalArgumentException(
                    new java.lang.StringBuilder("Expected ")
                        .append("value")
                        .append(" to be one of: com.hashicorp.cdktf.IResolvable, java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTarget>; received ")
                        .append(value.getClass()).toString());
            }
            if (value instanceof java.util.List) {
                @SuppressWarnings("unchecked")
                final java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTarget> __cast_cd4240 = (java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTarget>)value;
                for (int __idx_ac66f0 = 0; __idx_ac66f0 < __cast_cd4240.size(); __idx_ac66f0++) {
                    final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTarget __val_ac66f0 = __cast_cd4240.get(__idx_ac66f0);
                }
            }
        }
        software.amazon.jsii.Kernel.call(this, "putTarget", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void resetAlgorithm() {
        software.amazon.jsii.Kernel.call(this, "resetAlgorithm", software.amazon.jsii.NativeType.VOID);
    }

    public void resetDeleteProtection() {
        software.amazon.jsii.Kernel.call(this, "resetDeleteProtection", software.amazon.jsii.NativeType.VOID);
    }

    public void resetId() {
        software.amazon.jsii.Kernel.call(this, "resetId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetLabels() {
        software.amazon.jsii.Kernel.call(this, "resetLabels", software.amazon.jsii.NativeType.VOID);
    }

    public void resetLocation() {
        software.amazon.jsii.Kernel.call(this, "resetLocation", software.amazon.jsii.NativeType.VOID);
    }

    public void resetNetworkZone() {
        software.amazon.jsii.Kernel.call(this, "resetNetworkZone", software.amazon.jsii.NativeType.VOID);
    }

    public void resetTarget() {
        software.amazon.jsii.Kernel.call(this, "resetTarget", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeHclAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeHclAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public final static java.lang.String TF_RESOURCE_TYPE;

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithmOutputReference getAlgorithm() {
        return software.amazon.jsii.Kernel.get(this, "algorithm", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithmOutputReference.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv4() {
        return software.amazon.jsii.Kernel.get(this, "ipv4", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv6() {
        return software.amazon.jsii.Kernel.get(this, "ipv6", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getNetworkId() {
        return software.amazon.jsii.Kernel.get(this, "networkId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getNetworkIp() {
        return software.amazon.jsii.Kernel.get(this, "networkIp", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTargetList getTarget() {
        return software.amazon.jsii.Kernel.get(this, "target", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTargetList.class));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm getAlgorithmInput() {
        return software.amazon.jsii.Kernel.get(this, "algorithmInput", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getDeleteProtectionInput() {
        return software.amazon.jsii.Kernel.get(this, "deleteProtectionInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getIdInput() {
        return software.amazon.jsii.Kernel.get(this, "idInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getLabelsInput() {
        return java.util.Optional.ofNullable((java.util.Map<java.lang.String, java.lang.String>)(software.amazon.jsii.Kernel.get(this, "labelsInput", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))))).map(java.util.Collections::unmodifiableMap).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getLoadBalancerTypeInput() {
        return software.amazon.jsii.Kernel.get(this, "loadBalancerTypeInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getLocationInput() {
        return software.amazon.jsii.Kernel.get(this, "locationInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getNameInput() {
        return software.amazon.jsii.Kernel.get(this, "nameInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getNetworkZoneInput() {
        return software.amazon.jsii.Kernel.get(this, "networkZoneInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getTargetInput() {
        return software.amazon.jsii.Kernel.get(this, "targetInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getDeleteProtection() {
        return software.amazon.jsii.Kernel.get(this, "deleteProtection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setDeleteProtection(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "deleteProtection", java.util.Objects.requireNonNull(value, "deleteProtection is required"));
    }

    public void setDeleteProtection(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "deleteProtection", java.util.Objects.requireNonNull(value, "deleteProtection is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setId(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "id", java.util.Objects.requireNonNull(value, "id is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> getLabels() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))));
    }

    public void setLabels(final @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> value) {
        software.amazon.jsii.Kernel.set(this, "labels", java.util.Objects.requireNonNull(value, "labels is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLoadBalancerType() {
        return software.amazon.jsii.Kernel.get(this, "loadBalancerType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setLoadBalancerType(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "loadBalancerType", java.util.Objects.requireNonNull(value, "loadBalancerType is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLocation() {
        return software.amazon.jsii.Kernel.get(this, "location", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setLocation(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "location", java.util.Objects.requireNonNull(value, "location is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getName() {
        return software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setName(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "name", java.util.Objects.requireNonNull(value, "name is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getNetworkZone() {
        return software.amazon.jsii.Kernel.get(this, "networkZone", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setNetworkZone(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "networkZone", java.util.Objects.requireNonNull(value, "networkZone is required"));
    }

    /**
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer> {
        /**
         * @return a new instance of {@link Builder}.
         * @param scope The scope in which to define this construct. This parameter is required.
         * @param id The scoped construct ID. This parameter is required.
         */
        public static Builder create(final software.constructs.Construct scope, final java.lang.String id) {
            return new Builder(scope, id);
        }

        private final software.constructs.Construct scope;
        private final java.lang.String id;
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerConfig.Builder();
        }

        /**
         * @return {@code this}
         * @param connection This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(final com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.config.connection(connection);
            return this;
        }
        /**
         * @return {@code this}
         * @param connection This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(final com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.config.connection(connection);
            return this;
        }

        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final java.lang.Number count) {
            this.config.count(count);
            return this;
        }
        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final com.hashicorp.cdktf.TerraformCount count) {
            this.config.count(count);
            return this;
        }

        /**
         * @return {@code this}
         * @param dependsOn This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder dependsOn(final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.config.dependsOn(dependsOn);
            return this;
        }

        /**
         * @return {@code this}
         * @param forEach This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(final com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.config.forEach(forEach);
            return this;
        }

        /**
         * @return {@code this}
         * @param lifecycle This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.config.lifecycle(lifecycle);
            return this;
        }

        /**
         * @return {@code this}
         * @param provider This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(final com.hashicorp.cdktf.TerraformProvider provider) {
            this.config.provider(provider);
            return this;
        }

        /**
         * @return {@code this}
         * @param provisioners This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provisioners(final java.util.List<? extends java.lang.Object> provisioners) {
            this.config.provisioners(provisioners);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#load_balancer_type LoadBalancer#load_balancer_type}.
         * <p>
         * @return {@code this}
         * @param loadBalancerType Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#load_balancer_type LoadBalancer#load_balancer_type}. This parameter is required.
         */
        public Builder loadBalancerType(final java.lang.String loadBalancerType) {
            this.config.loadBalancerType(loadBalancerType);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#name LoadBalancer#name}.
         * <p>
         * @return {@code this}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#name LoadBalancer#name}. This parameter is required.
         */
        public Builder name(final java.lang.String name) {
            this.config.name(name);
            return this;
        }

        /**
         * algorithm block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#algorithm LoadBalancer#algorithm}
         * <p>
         * @return {@code this}
         * @param algorithm algorithm block. This parameter is required.
         */
        public Builder algorithm(final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerAlgorithm algorithm) {
            this.config.algorithm(algorithm);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}.
         * <p>
         * @return {@code this}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}. This parameter is required.
         */
        public Builder deleteProtection(final java.lang.Boolean deleteProtection) {
            this.config.deleteProtection(deleteProtection);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}.
         * <p>
         * @return {@code this}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#delete_protection LoadBalancer#delete_protection}. This parameter is required.
         */
        public Builder deleteProtection(final com.hashicorp.cdktf.IResolvable deleteProtection) {
            this.config.deleteProtection(deleteProtection);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#id LoadBalancer#id}.
         * <p>
         * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * <p>
         * @return {@code this}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#id LoadBalancer#id}. This parameter is required.
         */
        public Builder id(final java.lang.String id) {
            this.config.id(id);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#labels LoadBalancer#labels}.
         * <p>
         * @return {@code this}
         * @param labels Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#labels LoadBalancer#labels}. This parameter is required.
         */
        public Builder labels(final java.util.Map<java.lang.String, java.lang.String> labels) {
            this.config.labels(labels);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#location LoadBalancer#location}.
         * <p>
         * @return {@code this}
         * @param location Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#location LoadBalancer#location}. This parameter is required.
         */
        public Builder location(final java.lang.String location) {
            this.config.location(location);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#network_zone LoadBalancer#network_zone}.
         * <p>
         * @return {@code this}
         * @param networkZone Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#network_zone LoadBalancer#network_zone}. This parameter is required.
         */
        public Builder networkZone(final java.lang.String networkZone) {
            this.config.networkZone(networkZone);
            return this;
        }

        /**
         * target block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#target LoadBalancer#target}
         * <p>
         * @return {@code this}
         * @param target target block. This parameter is required.
         */
        public Builder target(final com.hashicorp.cdktf.IResolvable target) {
            this.config.target(target);
            return this;
        }
        /**
         * target block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/load_balancer#target LoadBalancer#target}
         * <p>
         * @return {@code this}
         * @param target target block. This parameter is required.
         */
        public Builder target(final java.util.List<? extends com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancerTarget> target) {
            this.config.target(target);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer.LoadBalancer(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
