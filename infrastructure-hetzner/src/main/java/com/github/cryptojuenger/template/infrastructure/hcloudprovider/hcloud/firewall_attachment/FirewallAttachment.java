package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment hcloud_firewall_attachment}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.334Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.firewallAttachment.FirewallAttachment")
public class FirewallAttachment extends com.hashicorp.cdktf.TerraformResource {

    protected FirewallAttachment(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected FirewallAttachment(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment hcloud_firewall_attachment} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public FirewallAttachment(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachmentConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    /**
     * Generates CDKTF code for importing a FirewallAttachment resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the FirewallAttachment to import. This parameter is required.
     * @param importFromId The id of the existing FirewallAttachment that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the FirewallAttachment to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a FirewallAttachment resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the FirewallAttachment to import. This parameter is required.
     * @param importFromId The id of the existing FirewallAttachment that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void resetId() {
        software.amazon.jsii.Kernel.call(this, "resetId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetLabelSelectors() {
        software.amazon.jsii.Kernel.call(this, "resetLabelSelectors", software.amazon.jsii.NativeType.VOID);
    }

    public void resetServerIds() {
        software.amazon.jsii.Kernel.call(this, "resetServerIds", software.amazon.jsii.NativeType.VOID);
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

    public @org.jetbrains.annotations.Nullable java.lang.Number getFirewallIdInput() {
        return software.amazon.jsii.Kernel.get(this, "firewallIdInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getIdInput() {
        return software.amazon.jsii.Kernel.get(this, "idInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getLabelSelectorsInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.String>)(software.amazon.jsii.Kernel.get(this, "labelSelectorsInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.Number> getServerIdsInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.Number>)(software.amazon.jsii.Kernel.get(this, "serverIdsInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getFirewallId() {
        return software.amazon.jsii.Kernel.get(this, "firewallId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setFirewallId(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "firewallId", java.util.Objects.requireNonNull(value, "firewallId is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setId(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "id", java.util.Objects.requireNonNull(value, "id is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getLabelSelectors() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "labelSelectors", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))));
    }

    public void setLabelSelectors(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> value) {
        software.amazon.jsii.Kernel.set(this, "labelSelectors", java.util.Objects.requireNonNull(value, "labelSelectors is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> getServerIds() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "serverIds", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))));
    }

    public void setServerIds(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> value) {
        software.amazon.jsii.Kernel.set(this, "serverIds", java.util.Objects.requireNonNull(value, "serverIds is required"));
    }

    /**
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment> {
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
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachmentConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachmentConfig.Builder();
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
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#firewall_id FirewallAttachment#firewall_id}.
         * <p>
         * @return {@code this}
         * @param firewallId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#firewall_id FirewallAttachment#firewall_id}. This parameter is required.
         */
        public Builder firewallId(final java.lang.Number firewallId) {
            this.config.firewallId(firewallId);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#id FirewallAttachment#id}.
         * <p>
         * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * <p>
         * @return {@code this}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#id FirewallAttachment#id}. This parameter is required.
         */
        public Builder id(final java.lang.String id) {
            this.config.id(id);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#label_selectors FirewallAttachment#label_selectors}.
         * <p>
         * @return {@code this}
         * @param labelSelectors Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#label_selectors FirewallAttachment#label_selectors}. This parameter is required.
         */
        public Builder labelSelectors(final java.util.List<java.lang.String> labelSelectors) {
            this.config.labelSelectors(labelSelectors);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#server_ids FirewallAttachment#server_ids}.
         * <p>
         * @return {@code this}
         * @param serverIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/firewall_attachment#server_ids FirewallAttachment#server_ids}. This parameter is required.
         */
        public Builder serverIds(final java.util.List<? extends java.lang.Number> serverIds) {
            this.config.serverIds(serverIds);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.firewall_attachment.FirewallAttachment(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
