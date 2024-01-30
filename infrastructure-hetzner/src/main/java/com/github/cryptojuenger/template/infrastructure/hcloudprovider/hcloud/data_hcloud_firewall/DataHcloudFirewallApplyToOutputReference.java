package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_firewall;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.268Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudFirewall.DataHcloudFirewallApplyToOutputReference")
public class DataHcloudFirewallApplyToOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected DataHcloudFirewallApplyToOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected DataHcloudFirewallApplyToOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     * @param complexObjectIndex the index of this item in the list. This parameter is required.
     * @param complexObjectIsFromSet whether the list is wrapping a set (will add tolist() to be able to access an item via an index). This parameter is required.
     */
    public DataHcloudFirewallApplyToOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute, final @org.jetbrains.annotations.NotNull java.lang.Number complexObjectIndex, final @org.jetbrains.annotations.NotNull java.lang.Boolean complexObjectIsFromSet) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required"), java.util.Objects.requireNonNull(complexObjectIndex, "complexObjectIndex is required"), java.util.Objects.requireNonNull(complexObjectIsFromSet, "complexObjectIsFromSet is required") });
    }

    public void resetLabelSelector() {
        software.amazon.jsii.Kernel.call(this, "resetLabelSelector", software.amazon.jsii.NativeType.VOID);
    }

    public void resetServer() {
        software.amazon.jsii.Kernel.call(this, "resetServer", software.amazon.jsii.NativeType.VOID);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getLabelSelectorInput() {
        return software.amazon.jsii.Kernel.get(this, "labelSelectorInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getServerInput() {
        return software.amazon.jsii.Kernel.get(this, "serverInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLabelSelector() {
        return software.amazon.jsii.Kernel.get(this, "labelSelector", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setLabelSelector(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "labelSelector", java.util.Objects.requireNonNull(value, "labelSelector is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getServer() {
        return software.amazon.jsii.Kernel.get(this, "server", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setServer(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "server", java.util.Objects.requireNonNull(value, "server is required"));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_firewall.DataHcloudFirewallApplyTo value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
