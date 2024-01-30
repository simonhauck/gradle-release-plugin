package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs hcloud}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.355Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.provider.HcloudProvider")
public class HcloudProvider extends com.hashicorp.cdktf.TerraformProvider {

    protected HcloudProvider(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected HcloudProvider(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs hcloud} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config
     */
    public HcloudProvider(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProviderConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), config });
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs hcloud} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     */
    public HcloudProvider(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required") });
    }

    /**
     * Generates CDKTF code for importing a HcloudProvider resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the HcloudProvider to import. This parameter is required.
     * @param importFromId The id of the existing HcloudProvider that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the HcloudProvider to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a HcloudProvider resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the HcloudProvider to import. This parameter is required.
     * @param importFromId The id of the existing HcloudProvider that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void resetAlias() {
        software.amazon.jsii.Kernel.call(this, "resetAlias", software.amazon.jsii.NativeType.VOID);
    }

    public void resetEndpoint() {
        software.amazon.jsii.Kernel.call(this, "resetEndpoint", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPollFunction() {
        software.amazon.jsii.Kernel.call(this, "resetPollFunction", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPollInterval() {
        software.amazon.jsii.Kernel.call(this, "resetPollInterval", software.amazon.jsii.NativeType.VOID);
    }

    public void resetToken() {
        software.amazon.jsii.Kernel.call(this, "resetToken", software.amazon.jsii.NativeType.VOID);
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

    public @org.jetbrains.annotations.Nullable java.lang.String getAliasInput() {
        return software.amazon.jsii.Kernel.get(this, "aliasInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getEndpointInput() {
        return software.amazon.jsii.Kernel.get(this, "endpointInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPollFunctionInput() {
        return software.amazon.jsii.Kernel.get(this, "pollFunctionInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPollIntervalInput() {
        return software.amazon.jsii.Kernel.get(this, "pollIntervalInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getTokenInput() {
        return software.amazon.jsii.Kernel.get(this, "tokenInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    @Override
    public @org.jetbrains.annotations.Nullable java.lang.String getAlias() {
        return software.amazon.jsii.Kernel.get(this, "alias", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    @Override
    public void setAlias(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "alias", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getEndpoint() {
        return software.amazon.jsii.Kernel.get(this, "endpoint", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setEndpoint(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "endpoint", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPollFunction() {
        return software.amazon.jsii.Kernel.get(this, "pollFunction", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setPollFunction(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "pollFunction", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPollInterval() {
        return software.amazon.jsii.Kernel.get(this, "pollInterval", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setPollInterval(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "pollInterval", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getToken() {
        return software.amazon.jsii.Kernel.get(this, "token", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setToken(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "token", value);
    }

    /**
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider> {
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
        private com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProviderConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
        }

        /**
         * Alias name.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#alias HcloudProvider#alias}
         * <p>
         * @return {@code this}
         * @param alias Alias name. This parameter is required.
         */
        public Builder alias(final java.lang.String alias) {
            this.config().alias(alias);
            return this;
        }

        /**
         * The Hetzner Cloud API endpoint, can be used to override the default API Endpoint https://api.hetzner.cloud/v1.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#endpoint HcloudProvider#endpoint}
         * <p>
         * @return {@code this}
         * @param endpoint The Hetzner Cloud API endpoint, can be used to override the default API Endpoint https://api.hetzner.cloud/v1. This parameter is required.
         */
        public Builder endpoint(final java.lang.String endpoint) {
            this.config().endpoint(endpoint);
            return this;
        }

        /**
         * The type of function to be used during the polling.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#poll_function HcloudProvider#poll_function}
         * <p>
         * @return {@code this}
         * @param pollFunction The type of function to be used during the polling. This parameter is required.
         */
        public Builder pollFunction(final java.lang.String pollFunction) {
            this.config().pollFunction(pollFunction);
            return this;
        }

        /**
         * The interval at which actions are polled by the client.
         * <p>
         * Default `500ms`. Increase this interval if you run into rate limiting errors.
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#poll_interval HcloudProvider#poll_interval}
         * <p>
         * @return {@code this}
         * @param pollInterval The interval at which actions are polled by the client. This parameter is required.
         */
        public Builder pollInterval(final java.lang.String pollInterval) {
            this.config().pollInterval(pollInterval);
            return this;
        }

        /**
         * The Hetzner Cloud API token, can also be specified with the HCLOUD_TOKEN environment variable.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs#token HcloudProvider#token}
         * <p>
         * @return {@code this}
         * @param token The Hetzner Cloud API token, can also be specified with the HCLOUD_TOKEN environment variable. This parameter is required.
         */
        public Builder token(final java.lang.String token) {
            this.config().token(token);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProvider(
                this.scope,
                this.id,
                this.config != null ? this.config.build() : null
            );
        }

        private com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProviderConfig.Builder config() {
            if (this.config == null) {
                this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.provider.HcloudProviderConfig.Builder();
            }
            return this.config;
        }
    }
}
