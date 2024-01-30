package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server;

/**
 * Represents a {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server hcloud_server}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.358Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.server.Server")
public class Server extends com.hashicorp.cdktf.TerraformResource {

    protected Server(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected Server(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    static {
        TF_RESOURCE_TYPE = software.amazon.jsii.JsiiObject.jsiiStaticGet(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server.class, "tfResourceType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    /**
     * Create a new {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server hcloud_server} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public Server(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    /**
     * Generates CDKTF code for importing a Server resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the Server to import. This parameter is required.
     * @param importFromId The id of the existing Server that should be imported. This parameter is required.
     * @param provider ? Optional instance of the provider where the Server to import is found.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId, final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.TerraformProvider provider) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required"), provider });
    }

    /**
     * Generates CDKTF code for importing a Server resource upon running "cdktf plan <stack-name>".
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param importToId The construct id used in the generated config for the Server to import. This parameter is required.
     * @param importFromId The id of the existing Server that should be imported. This parameter is required.
     */
    public static @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.ImportableResource generateConfigForImport(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String importToId, final @org.jetbrains.annotations.NotNull java.lang.String importFromId) {
        return software.amazon.jsii.JsiiObject.jsiiStaticCall(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server.class, "generateConfigForImport", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ImportableResource.class), new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(importToId, "importToId is required"), java.util.Objects.requireNonNull(importFromId, "importFromId is required") });
    }

    public void putNetwork(final @org.jetbrains.annotations.NotNull java.lang.Object value) {
        if (software.amazon.jsii.Configuration.getRuntimeTypeChecking()) {
            if (
                 !(value instanceof com.hashicorp.cdktf.IResolvable)
                && !(value instanceof java.util.List)
                && !(value.getClass().equals(software.amazon.jsii.JsiiObject.class))
            ) {
                throw new IllegalArgumentException(
                    new java.lang.StringBuilder("Expected ")
                        .append("value")
                        .append(" to be one of: com.hashicorp.cdktf.IResolvable, java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetwork>; received ")
                        .append(value.getClass()).toString());
            }
            if (value instanceof java.util.List) {
                @SuppressWarnings("unchecked")
                final java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetwork> __cast_cd4240 = (java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetwork>)value;
                for (int __idx_ac66f0 = 0; __idx_ac66f0 < __cast_cd4240.size(); __idx_ac66f0++) {
                    final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetwork __val_ac66f0 = __cast_cd4240.get(__idx_ac66f0);
                }
            }
        }
        software.amazon.jsii.Kernel.call(this, "putNetwork", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void putPublicNet(final @org.jetbrains.annotations.NotNull java.lang.Object value) {
        if (software.amazon.jsii.Configuration.getRuntimeTypeChecking()) {
            if (
                 !(value instanceof com.hashicorp.cdktf.IResolvable)
                && !(value instanceof java.util.List)
                && !(value.getClass().equals(software.amazon.jsii.JsiiObject.class))
            ) {
                throw new IllegalArgumentException(
                    new java.lang.StringBuilder("Expected ")
                        .append("value")
                        .append(" to be one of: com.hashicorp.cdktf.IResolvable, java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet>; received ")
                        .append(value.getClass()).toString());
            }
            if (value instanceof java.util.List) {
                @SuppressWarnings("unchecked")
                final java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet> __cast_cd4240 = (java.util.List<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet>)value;
                for (int __idx_ac66f0 = 0; __idx_ac66f0 < __cast_cd4240.size(); __idx_ac66f0++) {
                    final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet __val_ac66f0 = __cast_cd4240.get(__idx_ac66f0);
                }
            }
        }
        software.amazon.jsii.Kernel.call(this, "putPublicNet", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void putTimeouts(final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts value) {
        software.amazon.jsii.Kernel.call(this, "putTimeouts", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void resetAllowDeprecatedImages() {
        software.amazon.jsii.Kernel.call(this, "resetAllowDeprecatedImages", software.amazon.jsii.NativeType.VOID);
    }

    public void resetBackups() {
        software.amazon.jsii.Kernel.call(this, "resetBackups", software.amazon.jsii.NativeType.VOID);
    }

    public void resetDatacenter() {
        software.amazon.jsii.Kernel.call(this, "resetDatacenter", software.amazon.jsii.NativeType.VOID);
    }

    public void resetDeleteProtection() {
        software.amazon.jsii.Kernel.call(this, "resetDeleteProtection", software.amazon.jsii.NativeType.VOID);
    }

    public void resetFirewallIds() {
        software.amazon.jsii.Kernel.call(this, "resetFirewallIds", software.amazon.jsii.NativeType.VOID);
    }

    public void resetId() {
        software.amazon.jsii.Kernel.call(this, "resetId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetIgnoreRemoteFirewallIds() {
        software.amazon.jsii.Kernel.call(this, "resetIgnoreRemoteFirewallIds", software.amazon.jsii.NativeType.VOID);
    }

    public void resetImage() {
        software.amazon.jsii.Kernel.call(this, "resetImage", software.amazon.jsii.NativeType.VOID);
    }

    public void resetIso() {
        software.amazon.jsii.Kernel.call(this, "resetIso", software.amazon.jsii.NativeType.VOID);
    }

    public void resetKeepDisk() {
        software.amazon.jsii.Kernel.call(this, "resetKeepDisk", software.amazon.jsii.NativeType.VOID);
    }

    public void resetLabels() {
        software.amazon.jsii.Kernel.call(this, "resetLabels", software.amazon.jsii.NativeType.VOID);
    }

    public void resetLocation() {
        software.amazon.jsii.Kernel.call(this, "resetLocation", software.amazon.jsii.NativeType.VOID);
    }

    public void resetNetwork() {
        software.amazon.jsii.Kernel.call(this, "resetNetwork", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPlacementGroupId() {
        software.amazon.jsii.Kernel.call(this, "resetPlacementGroupId", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPublicNet() {
        software.amazon.jsii.Kernel.call(this, "resetPublicNet", software.amazon.jsii.NativeType.VOID);
    }

    public void resetRebuildProtection() {
        software.amazon.jsii.Kernel.call(this, "resetRebuildProtection", software.amazon.jsii.NativeType.VOID);
    }

    public void resetRescue() {
        software.amazon.jsii.Kernel.call(this, "resetRescue", software.amazon.jsii.NativeType.VOID);
    }

    public void resetShutdownBeforeDeletion() {
        software.amazon.jsii.Kernel.call(this, "resetShutdownBeforeDeletion", software.amazon.jsii.NativeType.VOID);
    }

    public void resetSshKeys() {
        software.amazon.jsii.Kernel.call(this, "resetSshKeys", software.amazon.jsii.NativeType.VOID);
    }

    public void resetTimeouts() {
        software.amazon.jsii.Kernel.call(this, "resetTimeouts", software.amazon.jsii.NativeType.VOID);
    }

    public void resetUserData() {
        software.amazon.jsii.Kernel.call(this, "resetUserData", software.amazon.jsii.NativeType.VOID);
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

    public @org.jetbrains.annotations.NotNull java.lang.String getBackupWindow() {
        return software.amazon.jsii.Kernel.get(this, "backupWindow", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
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

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetworkList getNetwork() {
        return software.amazon.jsii.Kernel.get(this, "network", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetworkList.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getPrimaryDiskSize() {
        return software.amazon.jsii.Kernel.get(this, "primaryDiskSize", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNetList getPublicNet() {
        return software.amazon.jsii.Kernel.get(this, "publicNet", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNetList.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getStatus() {
        return software.amazon.jsii.Kernel.get(this, "status", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeoutsOutputReference getTimeouts() {
        return software.amazon.jsii.Kernel.get(this, "timeouts", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeoutsOutputReference.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getAllowDeprecatedImagesInput() {
        return software.amazon.jsii.Kernel.get(this, "allowDeprecatedImagesInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getBackupsInput() {
        return software.amazon.jsii.Kernel.get(this, "backupsInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getDatacenterInput() {
        return software.amazon.jsii.Kernel.get(this, "datacenterInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getDeleteProtectionInput() {
        return software.amazon.jsii.Kernel.get(this, "deleteProtectionInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.Number> getFirewallIdsInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.Number>)(software.amazon.jsii.Kernel.get(this, "firewallIdsInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getIdInput() {
        return software.amazon.jsii.Kernel.get(this, "idInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getIgnoreRemoteFirewallIdsInput() {
        return software.amazon.jsii.Kernel.get(this, "ignoreRemoteFirewallIdsInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getImageInput() {
        return software.amazon.jsii.Kernel.get(this, "imageInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getIsoInput() {
        return software.amazon.jsii.Kernel.get(this, "isoInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getKeepDiskInput() {
        return software.amazon.jsii.Kernel.get(this, "keepDiskInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getLabelsInput() {
        return java.util.Optional.ofNullable((java.util.Map<java.lang.String, java.lang.String>)(software.amazon.jsii.Kernel.get(this, "labelsInput", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))))).map(java.util.Collections::unmodifiableMap).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getLocationInput() {
        return software.amazon.jsii.Kernel.get(this, "locationInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getNameInput() {
        return software.amazon.jsii.Kernel.get(this, "nameInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getNetworkInput() {
        return software.amazon.jsii.Kernel.get(this, "networkInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getPlacementGroupIdInput() {
        return software.amazon.jsii.Kernel.get(this, "placementGroupIdInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getPublicNetInput() {
        return software.amazon.jsii.Kernel.get(this, "publicNetInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getRebuildProtectionInput() {
        return software.amazon.jsii.Kernel.get(this, "rebuildProtectionInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getRescueInput() {
        return software.amazon.jsii.Kernel.get(this, "rescueInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getServerTypeInput() {
        return software.amazon.jsii.Kernel.get(this, "serverTypeInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getShutdownBeforeDeletionInput() {
        return software.amazon.jsii.Kernel.get(this, "shutdownBeforeDeletionInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getSshKeysInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.String>)(software.amazon.jsii.Kernel.get(this, "sshKeysInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getTimeoutsInput() {
        return software.amazon.jsii.Kernel.get(this, "timeoutsInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getUserDataInput() {
        return software.amazon.jsii.Kernel.get(this, "userDataInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getAllowDeprecatedImages() {
        return software.amazon.jsii.Kernel.get(this, "allowDeprecatedImages", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setAllowDeprecatedImages(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "allowDeprecatedImages", java.util.Objects.requireNonNull(value, "allowDeprecatedImages is required"));
    }

    public void setAllowDeprecatedImages(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "allowDeprecatedImages", java.util.Objects.requireNonNull(value, "allowDeprecatedImages is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getBackups() {
        return software.amazon.jsii.Kernel.get(this, "backups", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setBackups(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "backups", java.util.Objects.requireNonNull(value, "backups is required"));
    }

    public void setBackups(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "backups", java.util.Objects.requireNonNull(value, "backups is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDatacenter() {
        return software.amazon.jsii.Kernel.get(this, "datacenter", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setDatacenter(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "datacenter", java.util.Objects.requireNonNull(value, "datacenter is required"));
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

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> getFirewallIds() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "firewallIds", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))));
    }

    public void setFirewallIds(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> value) {
        software.amazon.jsii.Kernel.set(this, "firewallIds", java.util.Objects.requireNonNull(value, "firewallIds is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setId(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "id", java.util.Objects.requireNonNull(value, "id is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getIgnoreRemoteFirewallIds() {
        return software.amazon.jsii.Kernel.get(this, "ignoreRemoteFirewallIds", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setIgnoreRemoteFirewallIds(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "ignoreRemoteFirewallIds", java.util.Objects.requireNonNull(value, "ignoreRemoteFirewallIds is required"));
    }

    public void setIgnoreRemoteFirewallIds(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "ignoreRemoteFirewallIds", java.util.Objects.requireNonNull(value, "ignoreRemoteFirewallIds is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getImage() {
        return software.amazon.jsii.Kernel.get(this, "image", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setImage(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "image", java.util.Objects.requireNonNull(value, "image is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIso() {
        return software.amazon.jsii.Kernel.get(this, "iso", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setIso(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "iso", java.util.Objects.requireNonNull(value, "iso is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getKeepDisk() {
        return software.amazon.jsii.Kernel.get(this, "keepDisk", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setKeepDisk(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "keepDisk", java.util.Objects.requireNonNull(value, "keepDisk is required"));
    }

    public void setKeepDisk(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "keepDisk", java.util.Objects.requireNonNull(value, "keepDisk is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> getLabels() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))));
    }

    public void setLabels(final @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> value) {
        software.amazon.jsii.Kernel.set(this, "labels", java.util.Objects.requireNonNull(value, "labels is required"));
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

    public @org.jetbrains.annotations.NotNull java.lang.Number getPlacementGroupId() {
        return software.amazon.jsii.Kernel.get(this, "placementGroupId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setPlacementGroupId(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "placementGroupId", java.util.Objects.requireNonNull(value, "placementGroupId is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getRebuildProtection() {
        return software.amazon.jsii.Kernel.get(this, "rebuildProtection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setRebuildProtection(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "rebuildProtection", java.util.Objects.requireNonNull(value, "rebuildProtection is required"));
    }

    public void setRebuildProtection(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "rebuildProtection", java.util.Objects.requireNonNull(value, "rebuildProtection is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getRescue() {
        return software.amazon.jsii.Kernel.get(this, "rescue", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setRescue(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "rescue", java.util.Objects.requireNonNull(value, "rescue is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getServerType() {
        return software.amazon.jsii.Kernel.get(this, "serverType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setServerType(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "serverType", java.util.Objects.requireNonNull(value, "serverType is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getShutdownBeforeDeletion() {
        return software.amazon.jsii.Kernel.get(this, "shutdownBeforeDeletion", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setShutdownBeforeDeletion(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "shutdownBeforeDeletion", java.util.Objects.requireNonNull(value, "shutdownBeforeDeletion is required"));
    }

    public void setShutdownBeforeDeletion(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "shutdownBeforeDeletion", java.util.Objects.requireNonNull(value, "shutdownBeforeDeletion is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getSshKeys() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "sshKeys", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))));
    }

    public void setSshKeys(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> value) {
        software.amazon.jsii.Kernel.set(this, "sshKeys", java.util.Objects.requireNonNull(value, "sshKeys is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getUserData() {
        return software.amazon.jsii.Kernel.get(this, "userData", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setUserData(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "userData", java.util.Objects.requireNonNull(value, "userData is required"));
    }

    /**
     * A fluent builder for {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server> {
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
        private final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerConfig.Builder();
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
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#name Server#name}.
         * <p>
         * @return {@code this}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#name Server#name}. This parameter is required.
         */
        public Builder name(final java.lang.String name) {
            this.config.name(name);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#server_type Server#server_type}.
         * <p>
         * @return {@code this}
         * @param serverType Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#server_type Server#server_type}. This parameter is required.
         */
        public Builder serverType(final java.lang.String serverType) {
            this.config.serverType(serverType);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}.
         * <p>
         * @return {@code this}
         * @param allowDeprecatedImages Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}. This parameter is required.
         */
        public Builder allowDeprecatedImages(final java.lang.Boolean allowDeprecatedImages) {
            this.config.allowDeprecatedImages(allowDeprecatedImages);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}.
         * <p>
         * @return {@code this}
         * @param allowDeprecatedImages Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#allow_deprecated_images Server#allow_deprecated_images}. This parameter is required.
         */
        public Builder allowDeprecatedImages(final com.hashicorp.cdktf.IResolvable allowDeprecatedImages) {
            this.config.allowDeprecatedImages(allowDeprecatedImages);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}.
         * <p>
         * @return {@code this}
         * @param backups Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}. This parameter is required.
         */
        public Builder backups(final java.lang.Boolean backups) {
            this.config.backups(backups);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}.
         * <p>
         * @return {@code this}
         * @param backups Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#backups Server#backups}. This parameter is required.
         */
        public Builder backups(final com.hashicorp.cdktf.IResolvable backups) {
            this.config.backups(backups);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#datacenter Server#datacenter}.
         * <p>
         * @return {@code this}
         * @param datacenter Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#datacenter Server#datacenter}. This parameter is required.
         */
        public Builder datacenter(final java.lang.String datacenter) {
            this.config.datacenter(datacenter);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}.
         * <p>
         * @return {@code this}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}. This parameter is required.
         */
        public Builder deleteProtection(final java.lang.Boolean deleteProtection) {
            this.config.deleteProtection(deleteProtection);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}.
         * <p>
         * @return {@code this}
         * @param deleteProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#delete_protection Server#delete_protection}. This parameter is required.
         */
        public Builder deleteProtection(final com.hashicorp.cdktf.IResolvable deleteProtection) {
            this.config.deleteProtection(deleteProtection);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#firewall_ids Server#firewall_ids}.
         * <p>
         * @return {@code this}
         * @param firewallIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#firewall_ids Server#firewall_ids}. This parameter is required.
         */
        public Builder firewallIds(final java.util.List<? extends java.lang.Number> firewallIds) {
            this.config.firewallIds(firewallIds);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#id Server#id}.
         * <p>
         * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * <p>
         * @return {@code this}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#id Server#id}. This parameter is required.
         */
        public Builder id(final java.lang.String id) {
            this.config.id(id);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}.
         * <p>
         * @return {@code this}
         * @param ignoreRemoteFirewallIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}. This parameter is required.
         */
        public Builder ignoreRemoteFirewallIds(final java.lang.Boolean ignoreRemoteFirewallIds) {
            this.config.ignoreRemoteFirewallIds(ignoreRemoteFirewallIds);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}.
         * <p>
         * @return {@code this}
         * @param ignoreRemoteFirewallIds Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ignore_remote_firewall_ids Server#ignore_remote_firewall_ids}. This parameter is required.
         */
        public Builder ignoreRemoteFirewallIds(final com.hashicorp.cdktf.IResolvable ignoreRemoteFirewallIds) {
            this.config.ignoreRemoteFirewallIds(ignoreRemoteFirewallIds);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#image Server#image}.
         * <p>
         * @return {@code this}
         * @param image Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#image Server#image}. This parameter is required.
         */
        public Builder image(final java.lang.String image) {
            this.config.image(image);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#iso Server#iso}.
         * <p>
         * @return {@code this}
         * @param iso Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#iso Server#iso}. This parameter is required.
         */
        public Builder iso(final java.lang.String iso) {
            this.config.iso(iso);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}.
         * <p>
         * @return {@code this}
         * @param keepDisk Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}. This parameter is required.
         */
        public Builder keepDisk(final java.lang.Boolean keepDisk) {
            this.config.keepDisk(keepDisk);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}.
         * <p>
         * @return {@code this}
         * @param keepDisk Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#keep_disk Server#keep_disk}. This parameter is required.
         */
        public Builder keepDisk(final com.hashicorp.cdktf.IResolvable keepDisk) {
            this.config.keepDisk(keepDisk);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#labels Server#labels}.
         * <p>
         * @return {@code this}
         * @param labels Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#labels Server#labels}. This parameter is required.
         */
        public Builder labels(final java.util.Map<java.lang.String, java.lang.String> labels) {
            this.config.labels(labels);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#location Server#location}.
         * <p>
         * @return {@code this}
         * @param location Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#location Server#location}. This parameter is required.
         */
        public Builder location(final java.lang.String location) {
            this.config.location(location);
            return this;
        }

        /**
         * network block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network Server#network}
         * <p>
         * @return {@code this}
         * @param network network block. This parameter is required.
         */
        public Builder network(final com.hashicorp.cdktf.IResolvable network) {
            this.config.network(network);
            return this;
        }
        /**
         * network block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#network Server#network}
         * <p>
         * @return {@code this}
         * @param network network block. This parameter is required.
         */
        public Builder network(final java.util.List<? extends com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerNetwork> network) {
            this.config.network(network);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#placement_group_id Server#placement_group_id}.
         * <p>
         * @return {@code this}
         * @param placementGroupId Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#placement_group_id Server#placement_group_id}. This parameter is required.
         */
        public Builder placementGroupId(final java.lang.Number placementGroupId) {
            this.config.placementGroupId(placementGroupId);
            return this;
        }

        /**
         * public_net block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#public_net Server#public_net}
         * <p>
         * @return {@code this}
         * @param publicNet public_net block. This parameter is required.
         */
        public Builder publicNet(final com.hashicorp.cdktf.IResolvable publicNet) {
            this.config.publicNet(publicNet);
            return this;
        }
        /**
         * public_net block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#public_net Server#public_net}
         * <p>
         * @return {@code this}
         * @param publicNet public_net block. This parameter is required.
         */
        public Builder publicNet(final java.util.List<? extends com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet> publicNet) {
            this.config.publicNet(publicNet);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}.
         * <p>
         * @return {@code this}
         * @param rebuildProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}. This parameter is required.
         */
        public Builder rebuildProtection(final java.lang.Boolean rebuildProtection) {
            this.config.rebuildProtection(rebuildProtection);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}.
         * <p>
         * @return {@code this}
         * @param rebuildProtection Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rebuild_protection Server#rebuild_protection}. This parameter is required.
         */
        public Builder rebuildProtection(final com.hashicorp.cdktf.IResolvable rebuildProtection) {
            this.config.rebuildProtection(rebuildProtection);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rescue Server#rescue}.
         * <p>
         * @return {@code this}
         * @param rescue Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#rescue Server#rescue}. This parameter is required.
         */
        public Builder rescue(final java.lang.String rescue) {
            this.config.rescue(rescue);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}.
         * <p>
         * @return {@code this}
         * @param shutdownBeforeDeletion Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}. This parameter is required.
         */
        public Builder shutdownBeforeDeletion(final java.lang.Boolean shutdownBeforeDeletion) {
            this.config.shutdownBeforeDeletion(shutdownBeforeDeletion);
            return this;
        }
        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}.
         * <p>
         * @return {@code this}
         * @param shutdownBeforeDeletion Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#shutdown_before_deletion Server#shutdown_before_deletion}. This parameter is required.
         */
        public Builder shutdownBeforeDeletion(final com.hashicorp.cdktf.IResolvable shutdownBeforeDeletion) {
            this.config.shutdownBeforeDeletion(shutdownBeforeDeletion);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ssh_keys Server#ssh_keys}.
         * <p>
         * @return {@code this}
         * @param sshKeys Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#ssh_keys Server#ssh_keys}. This parameter is required.
         */
        public Builder sshKeys(final java.util.List<java.lang.String> sshKeys) {
            this.config.sshKeys(sshKeys);
            return this;
        }

        /**
         * timeouts block.
         * <p>
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#timeouts Server#timeouts}
         * <p>
         * @return {@code this}
         * @param timeouts timeouts block. This parameter is required.
         */
        public Builder timeouts(final com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerTimeouts timeouts) {
            this.config.timeouts(timeouts);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#user_data Server#user_data}.
         * <p>
         * @return {@code this}
         * @param userData Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/resources/server#user_data Server#user_data}. This parameter is required.
         */
        public Builder userData(final java.lang.String userData) {
            this.config.userData(userData);
            return this;
        }

        /**
         * @return a newly built instance of {@link com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server}.
         */
        @Override
        public com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server build() {
            return new com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.Server(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
