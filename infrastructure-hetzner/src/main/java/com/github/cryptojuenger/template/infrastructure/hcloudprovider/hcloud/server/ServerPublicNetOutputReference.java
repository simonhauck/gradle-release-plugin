package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.361Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.server.ServerPublicNetOutputReference")
public class ServerPublicNetOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected ServerPublicNetOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected ServerPublicNetOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     * @param complexObjectIndex the index of this item in the list. This parameter is required.
     * @param complexObjectIsFromSet whether the list is wrapping a set (will add tolist() to be able to access an item via an index). This parameter is required.
     */
    public ServerPublicNetOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute, final @org.jetbrains.annotations.NotNull java.lang.Number complexObjectIndex, final @org.jetbrains.annotations.NotNull java.lang.Boolean complexObjectIsFromSet) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required"), java.util.Objects.requireNonNull(complexObjectIndex, "complexObjectIndex is required"), java.util.Objects.requireNonNull(complexObjectIsFromSet, "complexObjectIsFromSet is required") });
    }

    public void resetIpv4() {
        software.amazon.jsii.Kernel.call(this, "resetIpv4", software.amazon.jsii.NativeType.VOID);
    }

    public void resetIpv4Enabled() {
        software.amazon.jsii.Kernel.call(this, "resetIpv4Enabled", software.amazon.jsii.NativeType.VOID);
    }

    public void resetIpv6() {
        software.amazon.jsii.Kernel.call(this, "resetIpv6", software.amazon.jsii.NativeType.VOID);
    }

    public void resetIpv6Enabled() {
        software.amazon.jsii.Kernel.call(this, "resetIpv6Enabled", software.amazon.jsii.NativeType.VOID);
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getIpv4EnabledInput() {
        return software.amazon.jsii.Kernel.get(this, "ipv4EnabledInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getIpv4Input() {
        return software.amazon.jsii.Kernel.get(this, "ipv4Input", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getIpv6EnabledInput() {
        return software.amazon.jsii.Kernel.get(this, "ipv6EnabledInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getIpv6Input() {
        return software.amazon.jsii.Kernel.get(this, "ipv6Input", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getIpv4() {
        return software.amazon.jsii.Kernel.get(this, "ipv4", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setIpv4(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "ipv4", java.util.Objects.requireNonNull(value, "ipv4 is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getIpv4Enabled() {
        return software.amazon.jsii.Kernel.get(this, "ipv4Enabled", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setIpv4Enabled(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "ipv4Enabled", java.util.Objects.requireNonNull(value, "ipv4Enabled is required"));
    }

    public void setIpv4Enabled(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "ipv4Enabled", java.util.Objects.requireNonNull(value, "ipv4Enabled is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getIpv6() {
        return software.amazon.jsii.Kernel.get(this, "ipv6", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setIpv6(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "ipv6", java.util.Objects.requireNonNull(value, "ipv6 is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getIpv6Enabled() {
        return software.amazon.jsii.Kernel.get(this, "ipv6Enabled", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setIpv6Enabled(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "ipv6Enabled", java.util.Objects.requireNonNull(value, "ipv6Enabled is required"));
    }

    public void setIpv6Enabled(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "ipv6Enabled", java.util.Objects.requireNonNull(value, "ipv6Enabled is required"));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.server.ServerPublicNet value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
