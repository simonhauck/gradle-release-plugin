package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_servers;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.320Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudServers.DataHcloudServersServersOutputReference")
public class DataHcloudServersServersOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected DataHcloudServersServersOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected DataHcloudServersServersOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     * @param complexObjectIndex the index of this item in the list. This parameter is required.
     * @param complexObjectIsFromSet whether the list is wrapping a set (will add tolist() to be able to access an item via an index). This parameter is required.
     */
    public DataHcloudServersServersOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute, final @org.jetbrains.annotations.NotNull java.lang.Number complexObjectIndex, final @org.jetbrains.annotations.NotNull java.lang.Boolean complexObjectIsFromSet) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required"), java.util.Objects.requireNonNull(complexObjectIndex, "complexObjectIndex is required"), java.util.Objects.requireNonNull(complexObjectIsFromSet, "complexObjectIsFromSet is required") });
    }

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

    public @org.jetbrains.annotations.NotNull java.lang.Number getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
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

    public @org.jetbrains.annotations.NotNull java.lang.String getName() {
        return software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getPlacementGroupId() {
        return software.amazon.jsii.Kernel.get(this, "placementGroupId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
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

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_servers.DataHcloudServersServers getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_servers.DataHcloudServersServers.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_servers.DataHcloudServersServers value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
