package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server hcloud_server}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.315Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudServer.DataHcloudServer")
public class DataHcloudServer extends com.hashicorp.cdktf.TerraformDataSource {

    protected DataHcloudServer(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected DataHcloudServer(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server hcloud_server} Data Source.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config
     */
    public DataHcloudServer(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServerConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), config });
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server hcloud_server} Data Source.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     */
    public DataHcloudServer(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required") });
    }

    /**
     * Generates CDKTF code for importing a DataHcloudServer resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the DataHcloudServer to import. This parameter is required.
     * @param importFromId The id of the existing DataHcloudServer that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the DataHcloudServer to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a DataHcloudServer resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the DataHcloudServer to import. This parameter is required.
     * @param importFromId The id of the existing DataHcloudServer that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void resetId() {
        software.amazon.jsii.Kernel.call(this, "resetId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetName() {
        software.amazon.jsii.Kernel.call(this, "resetName", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPlacementGroupId() {
        software.amazon.jsii.Kernel.call(this, "resetPlacementGroupId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetSelector() {
        software.amazon.jsii.Kernel.call(this, "resetSelector", software.amazon.jsii.NativeType.VOID);
    }

    public void resetWithSelector() {
        software.amazon.jsii.Kernel.call(this, "resetWithSelector", software.amazon.jsii.NativeType.VOID);
    }

    public void resetWithStatus() {
        software.amazon.jsii.Kernel.call(this, "resetWithStatus", software.amazon.jsii.NativeType.VOID);
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

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable getBackups() {
        return software.amazon.jsii.Kernel.get(this, "backups", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.IResolvable.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getBackupWindow() {
        return software.amazon.jsii.Kernel.get(this, "backupWindow", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDatacenter() {
        return software.amazon.jsii.Kernel.get(this, "datacenter", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable getDeleteProtection() {
        return software.amazon.jsii.Kernel.get(this, "deleteProtection", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.IResolvable.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> getFirewallIds() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "firewallIds", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getImage() {
        return software.amazon.jsii.Kernel.get(this, "image", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv4Address() {
        return software.amazon.jsii.Kernel.get(this, "ipv4Address", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv6Address() {
        return software.amazon.jsii.Kernel.get(this, "ipv6Address", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv6Network() {
        return software.amazon.jsii.Kernel.get(this, "ipv6Network", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIso() {
        return software.amazon.jsii.Kernel.get(this, "iso", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.StringMap getLabels() {
        return software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.StringMap.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLocation() {
        return software.amazon.jsii.Kernel.get(this, "location", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getPrimaryDiskSize() {
        return software.amazon.jsii.Kernel.get(this, "primaryDiskSize", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable getRebuildProtection() {
        return software.amazon.jsii.Kernel.get(this, "rebuildProtection", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.IResolvable.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getRescue() {
        return software.amazon.jsii.Kernel.get(this, "rescue", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getServerType() {
        return software.amazon.jsii.Kernel.get(this, "serverType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getStatus() {
        return software.amazon.jsii.Kernel.get(this, "status", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getIdInput() {
        return software.amazon.jsii.Kernel.get(this, "idInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getNameInput() {
        return software.amazon.jsii.Kernel.get(this, "nameInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getPlacementGroupIdInput() {
        return software.amazon.jsii.Kernel.get(this, "placementGroupIdInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getSelectorInput() {
        return software.amazon.jsii.Kernel.get(this, "selectorInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getWithSelectorInput() {
        return software.amazon.jsii.Kernel.get(this, "withSelectorInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getWithStatusInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.String>)(software.amazon.jsii.Kernel.get(this, "withStatusInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setId(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "id", java.util.Objects.requireNonNull(value, "id is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getName() {
        return software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setName(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "name", java.util.Objects.requireNonNull(value, "name is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getPlacementGroupId() {
        return software.amazon.jsii.Kernel.get(this, "placementGroupId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setPlacementGroupId(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "placementGroupId", java.util.Objects.requireNonNull(value, "placementGroupId is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getSelector() {
        return software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setSelector(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "selector", java.util.Objects.requireNonNull(value, "selector is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getWithSelector() {
        return software.amazon.jsii.Kernel.get(this, "withSelector", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setWithSelector(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "withSelector", java.util.Objects.requireNonNull(value, "withSelector is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getWithStatus() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "withStatus", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))));
    }

    public void setWithStatus(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> value) {
        software.amazon.jsii.Kernel.set(this, "withStatus", java.util.Objects.requireNonNull(value, "withStatus is required"));
    }

    /**
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer> {
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
        private com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServerConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
        }

        /**
         * @return {@code this}
         * @param connection This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(final com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.config().connection(connection);
            return this;
        }
        /**
         * @return {@code this}
         * @param connection This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(final com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.config().connection(connection);
            return this;
        }

        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final java.lang.Number count) {
            this.config().count(count);
            return this;
        }
        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final com.hashicorp.cdktf.TerraformCount count) {
            this.config().count(count);
            return this;
        }

        /**
         * @return {@code this}
         * @param dependsOn This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder dependsOn(final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.config().dependsOn(dependsOn);
            return this;
        }

        /**
         * @return {@code this}
         * @param forEach This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(final com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.config().forEach(forEach);
            return this;
        }

        /**
         * @return {@code this}
         * @param lifecycle This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.config().lifecycle(lifecycle);
            return this;
        }

        /**
         * @return {@code this}
         * @param provider This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(final com.hashicorp.cdktf.TerraformProvider provider) {
            this.config().provider(provider);
            return this;
        }

        /**
         * @return {@code this}
         * @param provisioners This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provisioners(final java.util.List<? extends java.lang.Object> provisioners) {
            this.config().provisioners(provisioners);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#id DataHcloudServer#id}.
         * <p>
         * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * <p>
         * @return {@code this}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#id DataHcloudServer#id}. This parameter is required.
         */
        public Builder id(final java.lang.Number id) {
            this.config().id(id);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#name DataHcloudServer#name}.
         * <p>
         * @return {@code this}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#name DataHcloudServer#name}. This parameter is required.
         */
        public Builder name(final java.lang.String name) {
            this.config().name(name);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#placement_group_id DataHcloudServer#placement_group_id}.
         * <p>
         * @return {@code this}
         * @param placementGroupId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#placement_group_id DataHcloudServer#placement_group_id}. This parameter is required.
         */
        public Builder placementGroupId(final java.lang.Number placementGroupId) {
            this.config().placementGroupId(placementGroupId);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#selector DataHcloudServer#selector}.
         * <p>
         * @return {@code this}
         * @param selector Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#selector DataHcloudServer#selector}. This parameter is required.
         */
        public Builder selector(final java.lang.String selector) {
            this.config().selector(selector);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#with_selector DataHcloudServer#with_selector}.
         * <p>
         * @return {@code this}
         * @param withSelector Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#with_selector DataHcloudServer#with_selector}. This parameter is required.
         */
        public Builder withSelector(final java.lang.String withSelector) {
            this.config().withSelector(withSelector);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#with_status DataHcloudServer#with_status}.
         * <p>
         * @return {@code this}
         * @param withStatus Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/server#with_status DataHcloudServer#with_status}. This parameter is required.
         */
        public Builder withStatus(final java.util.List<java.lang.String> withStatus) {
            this.config().withStatus(withStatus);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServer(
                this.scope,
                this.id,
                this.config != null ? this.config.build() : null
            );
        }

        private com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServerConfig.Builder config() {
            if (this.config == null) {
                this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server.DataHcloudServerConfig.Builder();
            }
            return this.config;
        }
    }
}
