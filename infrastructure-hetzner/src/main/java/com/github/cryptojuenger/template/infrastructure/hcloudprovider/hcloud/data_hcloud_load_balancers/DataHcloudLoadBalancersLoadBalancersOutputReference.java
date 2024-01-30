package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.295Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudLoadBalancers.DataHcloudLoadBalancersLoadBalancersOutputReference")
public class DataHcloudLoadBalancersLoadBalancersOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected DataHcloudLoadBalancersLoadBalancersOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected DataHcloudLoadBalancersLoadBalancersOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     * @param complexObjectIndex the index of this item in the list. This parameter is required.
     * @param complexObjectIsFromSet whether the list is wrapping a set (will add tolist() to be able to access an item via an index). This parameter is required.
     */
    public DataHcloudLoadBalancersLoadBalancersOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute, final @org.jetbrains.annotations.NotNull java.lang.Number complexObjectIndex, final @org.jetbrains.annotations.NotNull java.lang.Boolean complexObjectIsFromSet) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required"), java.util.Objects.requireNonNull(complexObjectIndex, "complexObjectIndex is required"), java.util.Objects.requireNonNull(complexObjectIsFromSet, "complexObjectIsFromSet is required") });
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancersAlgorithmList getAlgorithm() {
        return software.amazon.jsii.Kernel.get(this, "algorithm", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancersAlgorithmList.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable getDeleteProtection() {
        return software.amazon.jsii.Kernel.get(this, "deleteProtection", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.IResolvable.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv4() {
        return software.amazon.jsii.Kernel.get(this, "ipv4", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getIpv6() {
        return software.amazon.jsii.Kernel.get(this, "ipv6", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.StringMap getLabels() {
        return software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.StringMap.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLoadBalancerType() {
        return software.amazon.jsii.Kernel.get(this, "loadBalancerType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getLocation() {
        return software.amazon.jsii.Kernel.get(this, "location", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getName() {
        return software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getNetworkId() {
        return software.amazon.jsii.Kernel.get(this, "networkId", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getNetworkIp() {
        return software.amazon.jsii.Kernel.get(this, "networkIp", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getNetworkZone() {
        return software.amazon.jsii.Kernel.get(this, "networkZone", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancersServiceList getService() {
        return software.amazon.jsii.Kernel.get(this, "service", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancersServiceList.class));
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancersTargetList getTarget() {
        return software.amazon.jsii.Kernel.get(this, "target", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancersTargetList.class));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancers getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancers.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_load_balancers.DataHcloudLoadBalancersLoadBalancers value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
