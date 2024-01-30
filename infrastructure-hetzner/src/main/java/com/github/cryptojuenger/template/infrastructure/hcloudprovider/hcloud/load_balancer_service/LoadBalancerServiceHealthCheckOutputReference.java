package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.342Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceHealthCheckOutputReference")
public class LoadBalancerServiceHealthCheckOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected LoadBalancerServiceHealthCheckOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected LoadBalancerServiceHealthCheckOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     */
    public LoadBalancerServiceHealthCheckOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required") });
    }

    public void putHttp(final @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp value) {
        software.amazon.jsii.Kernel.call(this, "putHttp", software.amazon.jsii.NativeType.VOID, new Object[] { java.util.Objects.requireNonNull(value, "value is required") });
    }

    public void resetHttp() {
        software.amazon.jsii.Kernel.call(this, "resetHttp", software.amazon.jsii.NativeType.VOID);
    }

    public void resetRetries() {
        software.amazon.jsii.Kernel.call(this, "resetRetries", software.amazon.jsii.NativeType.VOID);
    }

    public @org.jetbrains.annotations.NotNull com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttpOutputReference getHttp() {
        return software.amazon.jsii.Kernel.get(this, "http", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttpOutputReference.class));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp getHttpInput() {
        return software.amazon.jsii.Kernel.get(this, "httpInput", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getIntervalInput() {
        return software.amazon.jsii.Kernel.get(this, "intervalInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getPortInput() {
        return software.amazon.jsii.Kernel.get(this, "portInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getProtocolInput() {
        return software.amazon.jsii.Kernel.get(this, "protocolInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getRetriesInput() {
        return software.amazon.jsii.Kernel.get(this, "retriesInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getTimeoutInput() {
        return software.amazon.jsii.Kernel.get(this, "timeoutInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getInterval() {
        return software.amazon.jsii.Kernel.get(this, "interval", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setInterval(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "interval", java.util.Objects.requireNonNull(value, "interval is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getPort() {
        return software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setPort(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "port", java.util.Objects.requireNonNull(value, "port is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getProtocol() {
        return software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setProtocol(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "protocol", java.util.Objects.requireNonNull(value, "protocol is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getRetries() {
        return software.amazon.jsii.Kernel.get(this, "retries", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setRetries(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "retries", java.util.Objects.requireNonNull(value, "retries is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getTimeout() {
        return software.amazon.jsii.Kernel.get(this, "timeout", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setTimeout(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "timeout", java.util.Objects.requireNonNull(value, "timeout is required"));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheck value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
