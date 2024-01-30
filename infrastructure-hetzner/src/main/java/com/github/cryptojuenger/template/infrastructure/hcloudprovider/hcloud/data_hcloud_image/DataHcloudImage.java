package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image hcloud_image}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.282Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudImage.DataHcloudImage")
public class DataHcloudImage extends com.hashicorp.cdktf.TerraformDataSource {

    protected DataHcloudImage(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected DataHcloudImage(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image hcloud_image} Data Source.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config
     */
    public DataHcloudImage(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImageConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), config });
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image hcloud_image} Data Source.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     */
    public DataHcloudImage(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required") });
    }

    /**
     * Generates CDKTF code for importing a DataHcloudImage resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the DataHcloudImage to import. This parameter is required.
     * @param importFromId The id of the existing DataHcloudImage that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the DataHcloudImage to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a DataHcloudImage resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the DataHcloudImage to import. This parameter is required.
     * @param importFromId The id of the existing DataHcloudImage that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void resetId() {
        software.amazon.jsii.Kernel.call(this, "resetId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetIncludeDeprecated() {
        software.amazon.jsii.Kernel.call(this, "resetIncludeDeprecated", software.amazon.jsii.NativeType.VOID);
    }

    public void resetMostRecent() {
        software.amazon.jsii.Kernel.call(this, "resetMostRecent", software.amazon.jsii.NativeType.VOID);
    }

    public void resetName() {
        software.amazon.jsii.Kernel.call(this, "resetName", software.amazon.jsii.NativeType.VOID);
    }

    public void resetSelector() {
        software.amazon.jsii.Kernel.call(this, "resetSelector", software.amazon.jsii.NativeType.VOID);
    }

    public void resetWithArchitecture() {
        software.amazon.jsii.Kernel.call(this, "resetWithArchitecture", software.amazon.jsii.NativeType.VOID);
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

    public @org.jetbrains.annotations.NotNull java.lang.String getArchitecture() {
        return software.amazon.jsii.Kernel.get(this, "architecture", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getCreated() {
        return software.amazon.jsii.Kernel.get(this, "created", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDeprecated() {
        return software.amazon.jsii.Kernel.get(this, "deprecated", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDescription() {
        return software.amazon.jsii.Kernel.get(this, "description", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.StringMap getLabels() {
        return software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.StringMap.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getOsFlavor() {
        return software.amazon.jsii.Kernel.get(this, "osFlavor", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getOsVersion() {
        return software.amazon.jsii.Kernel.get(this, "osVersion", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable getRapidDeploy() {
        return software.amazon.jsii.Kernel.get(this, "rapidDeploy", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.IResolvable.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getType() {
        return software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getIdInput() {
        return software.amazon.jsii.Kernel.get(this, "idInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getIncludeDeprecatedInput() {
        return software.amazon.jsii.Kernel.get(this, "includeDeprecatedInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getMostRecentInput() {
        return software.amazon.jsii.Kernel.get(this, "mostRecentInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getNameInput() {
        return software.amazon.jsii.Kernel.get(this, "nameInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getSelectorInput() {
        return software.amazon.jsii.Kernel.get(this, "selectorInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getWithArchitectureInput() {
        return software.amazon.jsii.Kernel.get(this, "withArchitectureInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
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

    public @org.jetbrains.annotations.NotNull java.lang.Object getIncludeDeprecated() {
        return software.amazon.jsii.Kernel.get(this, "includeDeprecated", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setIncludeDeprecated(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "includeDeprecated", java.util.Objects.requireNonNull(value, "includeDeprecated is required"));
    }

    public void setIncludeDeprecated(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "includeDeprecated", java.util.Objects.requireNonNull(value, "includeDeprecated is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getMostRecent() {
        return software.amazon.jsii.Kernel.get(this, "mostRecent", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setMostRecent(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "mostRecent", java.util.Objects.requireNonNull(value, "mostRecent is required"));
    }

    public void setMostRecent(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "mostRecent", java.util.Objects.requireNonNull(value, "mostRecent is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getName() {
        return software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setName(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "name", java.util.Objects.requireNonNull(value, "name is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getSelector() {
        return software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setSelector(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "selector", java.util.Objects.requireNonNull(value, "selector is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getWithArchitecture() {
        return software.amazon.jsii.Kernel.get(this, "withArchitecture", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setWithArchitecture(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "withArchitecture", java.util.Objects.requireNonNull(value, "withArchitecture is required"));
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
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage> {
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
        private com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImageConfig.Builder config;

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
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#id DataHcloudImage#id}.
         * <p>
         * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * <p>
         * @return {@code this}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#id DataHcloudImage#id}. This parameter is required.
         */
        public Builder id(final java.lang.Number id) {
            this.config().id(id);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#include_deprecated DataHcloudImage#include_deprecated}.
         * <p>
         * @return {@code this}
         * @param includeDeprecated Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#include_deprecated DataHcloudImage#include_deprecated}. This parameter is required.
         */
        public Builder includeDeprecated(final java.lang.Boolean includeDeprecated) {
            this.config().includeDeprecated(includeDeprecated);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#include_deprecated DataHcloudImage#include_deprecated}.
         * <p>
         * @return {@code this}
         * @param includeDeprecated Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#include_deprecated DataHcloudImage#include_deprecated}. This parameter is required.
         */
        public Builder includeDeprecated(final com.hashicorp.cdktf.IResolvable includeDeprecated) {
            this.config().includeDeprecated(includeDeprecated);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#most_recent DataHcloudImage#most_recent}.
         * <p>
         * @return {@code this}
         * @param mostRecent Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#most_recent DataHcloudImage#most_recent}. This parameter is required.
         */
        public Builder mostRecent(final java.lang.Boolean mostRecent) {
            this.config().mostRecent(mostRecent);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#most_recent DataHcloudImage#most_recent}.
         * <p>
         * @return {@code this}
         * @param mostRecent Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#most_recent DataHcloudImage#most_recent}. This parameter is required.
         */
        public Builder mostRecent(final com.hashicorp.cdktf.IResolvable mostRecent) {
            this.config().mostRecent(mostRecent);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#name DataHcloudImage#name}.
         * <p>
         * @return {@code this}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#name DataHcloudImage#name}. This parameter is required.
         */
        public Builder name(final java.lang.String name) {
            this.config().name(name);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#selector DataHcloudImage#selector}.
         * <p>
         * @return {@code this}
         * @param selector Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#selector DataHcloudImage#selector}. This parameter is required.
         */
        public Builder selector(final java.lang.String selector) {
            this.config().selector(selector);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#with_architecture DataHcloudImage#with_architecture}.
         * <p>
         * @return {@code this}
         * @param withArchitecture Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#with_architecture DataHcloudImage#with_architecture}. This parameter is required.
         */
        public Builder withArchitecture(final java.lang.String withArchitecture) {
            this.config().withArchitecture(withArchitecture);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#with_selector DataHcloudImage#with_selector}.
         * <p>
         * @return {@code this}
         * @param withSelector Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#with_selector DataHcloudImage#with_selector}. This parameter is required.
         */
        public Builder withSelector(final java.lang.String withSelector) {
            this.config().withSelector(withSelector);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#with_status DataHcloudImage#with_status}.
         * <p>
         * @return {@code this}
         * @param withStatus Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/image#with_status DataHcloudImage#with_status}. This parameter is required.
         */
        public Builder withStatus(final java.util.List<java.lang.String> withStatus) {
            this.config().withStatus(withStatus);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImage(
                this.scope,
                this.id,
                this.config != null ? this.config.build() : null
            );
        }

        private com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImageConfig.Builder config() {
            if (this.config == null) {
                this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_image.DataHcloudImageConfig.Builder();
            }
            return this.config;
        }
    }
}
