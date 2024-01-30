package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.342Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.loadBalancerService.LoadBalancerServiceHttpOutputReference")
public class LoadBalancerServiceHttpOutputReference extends com.hashicorp.cdktf.ComplexObject {

    protected LoadBalancerServiceHttpOutputReference(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected LoadBalancerServiceHttpOutputReference(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * @param terraformResource The parent resource. This parameter is required.
     * @param terraformAttribute The attribute on the parent resource this class is referencing. This parameter is required.
     */
    public LoadBalancerServiceHttpOutputReference(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IInterpolatingParent terraformResource, final @org.jetbrains.annotations.NotNull java.lang.String terraformAttribute) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(terraformResource, "terraformResource is required"), java.util.Objects.requireNonNull(terraformAttribute, "terraformAttribute is required") });
    }

    public void resetCertificates() {
        software.amazon.jsii.Kernel.call(this, "resetCertificates", software.amazon.jsii.NativeType.VOID);
    }

    public void resetCookieLifetime() {
        software.amazon.jsii.Kernel.call(this, "resetCookieLifetime", software.amazon.jsii.NativeType.VOID);
    }

    public void resetCookieName() {
        software.amazon.jsii.Kernel.call(this, "resetCookieName", software.amazon.jsii.NativeType.VOID);
    }

    public void resetRedirectHttp() {
        software.amazon.jsii.Kernel.call(this, "resetRedirectHttp", software.amazon.jsii.NativeType.VOID);
    }

    public void resetStickySessions() {
        software.amazon.jsii.Kernel.call(this, "resetStickySessions", software.amazon.jsii.NativeType.VOID);
    }

    public @org.jetbrains.annotations.Nullable java.util.List<java.lang.Number> getCertificatesInput() {
        return java.util.Optional.ofNullable((java.util.List<java.lang.Number>)(software.amazon.jsii.Kernel.get(this, "certificatesInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.Number getCookieLifetimeInput() {
        return software.amazon.jsii.Kernel.get(this, "cookieLifetimeInput", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getCookieNameInput() {
        return software.amazon.jsii.Kernel.get(this, "cookieNameInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getRedirectHttpInput() {
        return software.amazon.jsii.Kernel.get(this, "redirectHttpInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Object getStickySessionsInput() {
        return software.amazon.jsii.Kernel.get(this, "stickySessionsInput", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> getCertificates() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "certificates", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Number.class))));
    }

    public void setCertificates(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.Number> value) {
        software.amazon.jsii.Kernel.set(this, "certificates", java.util.Objects.requireNonNull(value, "certificates is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Number getCookieLifetime() {
        return software.amazon.jsii.Kernel.get(this, "cookieLifetime", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
    }

    public void setCookieLifetime(final @org.jetbrains.annotations.NotNull java.lang.Number value) {
        software.amazon.jsii.Kernel.set(this, "cookieLifetime", java.util.Objects.requireNonNull(value, "cookieLifetime is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getCookieName() {
        return software.amazon.jsii.Kernel.get(this, "cookieName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setCookieName(final @org.jetbrains.annotations.NotNull java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "cookieName", java.util.Objects.requireNonNull(value, "cookieName is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getRedirectHttp() {
        return software.amazon.jsii.Kernel.get(this, "redirectHttp", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setRedirectHttp(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "redirectHttp", java.util.Objects.requireNonNull(value, "redirectHttp is required"));
    }

    public void setRedirectHttp(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "redirectHttp", java.util.Objects.requireNonNull(value, "redirectHttp is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Object getStickySessions() {
        return software.amazon.jsii.Kernel.get(this, "stickySessions", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
    }

    public void setStickySessions(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "stickySessions", java.util.Objects.requireNonNull(value, "stickySessions is required"));
    }

    public void setStickySessions(final @org.jetbrains.annotations.NotNull com.hashicorp.cdktf.IResolvable value) {
        software.amazon.jsii.Kernel.set(this, "stickySessions", java.util.Objects.requireNonNull(value, "stickySessions is required"));
    }

    public @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp getInternalValue() {
        return software.amazon.jsii.Kernel.get(this, "internalValue", software.amazon.jsii.NativeType.forClass(com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp.class));
    }

    public void setInternalValue(final @org.jetbrains.annotations.Nullable com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.load_balancer_service.LoadBalancerServiceHttp value) {
        software.amazon.jsii.Kernel.set(this, "internalValue", value);
    }
}
