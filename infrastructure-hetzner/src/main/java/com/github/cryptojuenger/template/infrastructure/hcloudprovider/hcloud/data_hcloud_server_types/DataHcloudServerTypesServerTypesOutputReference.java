package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server_types;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.318Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudServerTypes.DataHcloudServerTypesServerTypesOutputReference")
public class DataHcloudServerTypesServerTypesOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected DataHcloudServerTypesServerTypesOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected DataHcloudServerTypesServerTypesOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     * @param complexObjectIndex the index of this item in the list. This parameter is required.
     * @param complexObjectIsFromSet whether the list is wrapping a set (will add tolist() to be able to access an item via an index). This parameter is required.
     */
    public DataHcloudServerTypesServerTypesOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute, final @org.jetbrains.annotations.NotNull java.lang.Number complexObjectIndex, final @org.jetbrains.annotations.NotNull java.lang.Boolean complexObjectIsFromSet) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required"), java.util.Objects.requireNonNull(complexObjectIndex, "complexObjectIndex is required"), java.util.Objects.requireNonNull(complexObjectIsFromSet, "complexObjectIsFromSet is required") });
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getArchitecture() {
        return software.amazon.jsii.Kernel.get(this, "architecture", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getCores() {
        return software.amazon.jsii.Kernel.get(this, "cores", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getCpuType() {
        return software.amazon.jsii.Kernel.get(this, "cpuType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDeprecationAnnounced() {
        return software.amazon.jsii.Kernel.get(this, "deprecationAnnounced", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDescription() {
        return software.amazon.jsii.Kernel.get(this, "description", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getDisk() {
        return software.amazon.jsii.Kernel.get(this, "disk", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getIncludedTraffic() {
        return software.amazon.jsii.Kernel.get(this, "includedTraffic", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable getIsDeprecated() {
        return software.amazon.jsii.Kernel.get(this, "isDeprecated", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.IResolvable.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getMemory() {
        return software.amazon.jsii.Kernel.get(this, "memory", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getName() {
        return software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getStorageType() {
        return software.amazon.jsii.Kernel.get(this, "storageType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getUnavailableAfter() {
        return software.amazon.jsii.Kernel.get(this, "unavailableAfter", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server_types.DataHcloudServerTypesServerTypes getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server_types.DataHcloudServerTypesServerTypes.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_server_types.DataHcloudServerTypesServerTypes value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
