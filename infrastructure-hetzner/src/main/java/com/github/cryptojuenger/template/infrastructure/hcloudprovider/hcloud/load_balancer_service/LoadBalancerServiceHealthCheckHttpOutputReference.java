package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.342Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceHealthCheckHttpOutputReference")
public class LoadBalancerServiceHealthCheckHttpOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected LoadBalancerServiceHealthCheckHttpOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected LoadBalancerServiceHealthCheckHttpOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     */
    public LoadBalancerServiceHealthCheckHttpOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required") });
    }

    public void resetDomain() {
        software.amazon.jsii.Kernel.call(this, "resetDomain", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPath() {
        software.amazon.jsii.Kernel.call(this, "resetPath", software.amazon.jsii.NativeType.VOID);
    }

    public void resetResponse() {
        software.amazon.jsii.Kernel.call(this, "resetResponse", software.amazon.jsii.NativeType.VOID);
    }

    public void resetStatusCodes() {
        software.amazon.jsii.Kernel.call(this, "resetStatusCodes", software.amazon.jsii.NativeType.VOID);
    }

    public void resetTls() {
        software.amazon.jsii.Kernel.call(this, "resetTls", software.amazon.jsii.NativeType.VOID);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getDomainInput() {
        return software.amazon.jsii.Kernel.get(this, "domainInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPathInput() {
        return software.amazon.jsii.Kernel.get(this, "pathInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getResponseInput() {
        return software.amazon.jsii.Kernel.get(this, "responseInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getStatusCodesInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.String>)(software.amazon.jsii.Kernel.get(this, "statusCodesInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getTlsInput() {
        return software.amazon.jsii.Kernel.get(this, "tlsInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDomain() {
        return software.amazon.jsii.Kernel.get(this, "domain", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setDomain(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "domain", java.util.Objects.requireNonNull(value, "domain is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getPath() {
        return software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setPath(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "path", java.util.Objects.requireNonNull(value, "path is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getResponse() {
        return software.amazon.jsii.Kernel.get(this, "response", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setResponse(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "response", java.util.Objects.requireNonNull(value, "response is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getStatusCodes() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "statusCodes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class))));
    }

    public void setStatusCodes(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> value) {
        software.amazon.jsii.Kernel.set(this, "statusCodes", java.util.Objects.requireNonNull(value, "statusCodes is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getTls() {
        return software.amazon.jsii.Kernel.get(this, "tls", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setTls(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "tls", java.util.Objects.requireNonNull(value, "tls is required"));
    }

    public void setTls(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "tls", java.util.Objects.requireNonNull(value, "tls is required"));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHealthCheckHttp value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
