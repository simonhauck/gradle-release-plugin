package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_images;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.285Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudImages.DataHcloudImagesConfig")
@software.amazon.jsii.Jsii.Proxy(DataHcloudImagesConfig.Jsii$Proxy.class)
public interface DataHcloudImagesConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#id DataHcloudImages#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#include_deprecated DataHcloudImages#include_deprecated}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getIncludeDeprecated() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#most_recent DataHcloudImages#most_recent}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Object getMostRecent() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#with_architecture DataHcloudImages#with_architecture}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getWithArchitecture() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#with_selector DataHcloudImages#with_selector}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getWithSelector() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#with_status DataHcloudImages#with_status}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getWithStatus() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DataHcloudImagesConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DataHcloudImagesConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DataHcloudImagesConfig> {
        java.lang.String id;
        java.lang.Object includeDeprecated;
        java.lang.Object mostRecent;
        java.util.List<java.lang.String> withArchitecture;
        java.lang.String withSelector;
        java.util.List<java.lang.String> withStatus;
        java.lang.Object connection;
        java.lang.Object count;
        java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        com.hashicorp.cdktf.ITerraformIterator forEach;
        com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        com.hashicorp.cdktf.TerraformProvider provider;
        java.util.List<java.lang.Object> provisioners;

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#id DataHcloudImages#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getIncludeDeprecated}
         * @param includeDeprecated Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#include_deprecated DataHcloudImages#include_deprecated}.
         * @return {@code this}
         */
        public Builder includeDeprecated(java.lang.Boolean includeDeprecated) {
            this.includeDeprecated = includeDeprecated;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getIncludeDeprecated}
         * @param includeDeprecated Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#include_deprecated DataHcloudImages#include_deprecated}.
         * @return {@code this}
         */
        public Builder includeDeprecated(com.hashicorp.cdktf.IResolvable includeDeprecated) {
            this.includeDeprecated = includeDeprecated;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getMostRecent}
         * @param mostRecent Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#most_recent DataHcloudImages#most_recent}.
         * @return {@code this}
         */
        public Builder mostRecent(java.lang.Boolean mostRecent) {
            this.mostRecent = mostRecent;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getMostRecent}
         * @param mostRecent Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#most_recent DataHcloudImages#most_recent}.
         * @return {@code this}
         */
        public Builder mostRecent(com.hashicorp.cdktf.IResolvable mostRecent) {
            this.mostRecent = mostRecent;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getWithArchitecture}
         * @param withArchitecture Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#with_architecture DataHcloudImages#with_architecture}.
         * @return {@code this}
         */
        public Builder withArchitecture(java.util.List<java.lang.String> withArchitecture) {
            this.withArchitecture = withArchitecture;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getWithSelector}
         * @param withSelector Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#with_selector DataHcloudImages#with_selector}.
         * @return {@code this}
         */
        public Builder withSelector(java.lang.String withSelector) {
            this.withSelector = withSelector;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getWithStatus}
         * @param withStatus Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/images#with_status DataHcloudImages#with_status}.
         * @return {@code this}
         */
        public Builder withStatus(java.util.List<java.lang.String> withStatus) {
            this.withStatus = withStatus;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.SSHProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getConnection}
         * @param connection the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder connection(com.hashicorp.cdktf.WinrmProvisionerConnection connection) {
            this.connection = connection;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(com.hashicorp.cdktf.TerraformCount count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getDependsOn}
         * @param dependsOn the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder dependsOn(java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getForEach}
         * @param forEach the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder forEach(com.hashicorp.cdktf.ITerraformIterator forEach) {
            this.forEach = forEach;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudImagesConfig#getProvisioners}
         * @param provisioners the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder provisioners(java.util.List<? extends java.lang.Object> provisioners) {
            this.provisioners = (java.util.List<java.lang.Object>)provisioners;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DataHcloudImagesConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DataHcloudImagesConfig build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link DataHcloudImagesConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DataHcloudImagesConfig {
        private final java.lang.String id;
        private final java.lang.Object includeDeprecated;
        private final java.lang.Object mostRecent;
        private final java.util.List<java.lang.String> withArchitecture;
        private final java.lang.String withSelector;
        private final java.util.List<java.lang.String> withStatus;
        private final java.lang.Object connection;
        private final java.lang.Object count;
        private final java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private final com.hashicorp.cdktf.ITerraformIterator forEach;
        private final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private final com.hashicorp.cdktf.TerraformProvider provider;
        private final java.util.List<java.lang.Object> provisioners;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.includeDeprecated = software.amazon.jsii.Kernel.get(this, "includeDeprecated", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.mostRecent = software.amazon.jsii.Kernel.get(this, "mostRecent", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.withArchitecture = software.amazon.jsii.Kernel.get(this, "withArchitecture", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.withSelector = software.amazon.jsii.Kernel.get(this, "withSelector", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.withStatus = software.amazon.jsii.Kernel.get(this, "withStatus", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.connection = software.amazon.jsii.Kernel.get(this, "connection", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.count = software.amazon.jsii.Kernel.get(this, "count", software.amazon.jsii.NativeType.forClass(java.lang.Object.class));
            this.dependsOn = software.amazon.jsii.Kernel.get(this, "dependsOn", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformDependable.class)));
            this.forEach = software.amazon.jsii.Kernel.get(this, "forEach", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformIterator.class));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformResourceLifecycle.class));
            this.provider = software.amazon.jsii.Kernel.get(this, "provider", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformProvider.class));
            this.provisioners = software.amazon.jsii.Kernel.get(this, "provisioners", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.id = builder.id;
            this.includeDeprecated = builder.includeDeprecated;
            this.mostRecent = builder.mostRecent;
            this.withArchitecture = builder.withArchitecture;
            this.withSelector = builder.withSelector;
            this.withStatus = builder.withStatus;
            this.connection = builder.connection;
            this.count = builder.count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)builder.dependsOn;
            this.forEach = builder.forEach;
            this.lifecycle = builder.lifecycle;
            this.provider = builder.provider;
            this.provisioners = (java.util.List<java.lang.Object>)builder.provisioners;
        }

        @Override
        public final java.lang.String getId() {
            return this.id;
        }

        @Override
        public final java.lang.Object getIncludeDeprecated() {
            return this.includeDeprecated;
        }

        @Override
        public final java.lang.Object getMostRecent() {
            return this.mostRecent;
        }

        @Override
        public final java.util.List<java.lang.String> getWithArchitecture() {
            return this.withArchitecture;
        }

        @Override
        public final java.lang.String getWithSelector() {
            return this.withSelector;
        }

        @Override
        public final java.util.List<java.lang.String> getWithStatus() {
            return this.withStatus;
        }

        @Override
        public final java.lang.Object getConnection() {
            return this.connection;
        }

        @Override
        public final java.lang.Object getCount() {
            return this.count;
        }

        @Override
        public final java.util.List<com.hashicorp.cdktf.ITerraformDependable> getDependsOn() {
            return this.dependsOn;
        }

        @Override
        public final com.hashicorp.cdktf.ITerraformIterator getForEach() {
            return this.forEach;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformResourceLifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformProvider getProvider() {
            return this.provider;
        }

        @Override
        public final java.util.List<java.lang.Object> getProvisioners() {
            return this.provisioners;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getIncludeDeprecated() != null) {
                data.set("includeDeprecated", om.valueToTree(this.getIncludeDeprecated()));
            }
            if (this.getMostRecent() != null) {
                data.set("mostRecent", om.valueToTree(this.getMostRecent()));
            }
            if (this.getWithArchitecture() != null) {
                data.set("withArchitecture", om.valueToTree(this.getWithArchitecture()));
            }
            if (this.getWithSelector() != null) {
                data.set("withSelector", om.valueToTree(this.getWithSelector()));
            }
            if (this.getWithStatus() != null) {
                data.set("withStatus", om.valueToTree(this.getWithStatus()));
            }
            if (this.getConnection() != null) {
                data.set("connection", om.valueToTree(this.getConnection()));
            }
            if (this.getCount() != null) {
                data.set("count", om.valueToTree(this.getCount()));
            }
            if (this.getDependsOn() != null) {
                data.set("dependsOn", om.valueToTree(this.getDependsOn()));
            }
            if (this.getForEach() != null) {
                data.set("forEach", om.valueToTree(this.getForEach()));
            }
            if (this.getLifecycle() != null) {
                data.set("lifecycle", om.valueToTree(this.getLifecycle()));
            }
            if (this.getProvider() != null) {
                data.set("provider", om.valueToTree(this.getProvider()));
            }
            if (this.getProvisioners() != null) {
                data.set("provisioners", om.valueToTree(this.getProvisioners()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.dataHcloudImages.DataHcloudImagesConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataHcloudImagesConfig.Jsii$Proxy that = (DataHcloudImagesConfig.Jsii$Proxy) o;

            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            if (this.includeDeprecated != null ? !this.includeDeprecated.equals(that.includeDeprecated) : that.includeDeprecated != null) return false;
            if (this.mostRecent != null ? !this.mostRecent.equals(that.mostRecent) : that.mostRecent != null) return false;
            if (this.withArchitecture != null ? !this.withArchitecture.equals(that.withArchitecture) : that.withArchitecture != null) return false;
            if (this.withSelector != null ? !this.withSelector.equals(that.withSelector) : that.withSelector != null) return false;
            if (this.withStatus != null ? !this.withStatus.equals(that.withStatus) : that.withStatus != null) return false;
            if (this.connection != null ? !this.connection.equals(that.connection) : that.connection != null) return false;
            if (this.count != null ? !this.count.equals(that.count) : that.count != null) return false;
            if (this.dependsOn != null ? !this.dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
            if (this.forEach != null ? !this.forEach.equals(that.forEach) : that.forEach != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            if (this.provider != null ? !this.provider.equals(that.provider) : that.provider != null) return false;
            return this.provisioners != null ? this.provisioners.equals(that.provisioners) : that.provisioners == null;
        }

        @Override
        public final int hashCode() {
            int result = this.id != null ? this.id.hashCode() : 0;
            result = 31 * result + (this.includeDeprecated != null ? this.includeDeprecated.hashCode() : 0);
            result = 31 * result + (this.mostRecent != null ? this.mostRecent.hashCode() : 0);
            result = 31 * result + (this.withArchitecture != null ? this.withArchitecture.hashCode() : 0);
            result = 31 * result + (this.withSelector != null ? this.withSelector.hashCode() : 0);
            result = 31 * result + (this.withStatus != null ? this.withStatus.hashCode() : 0);
            result = 31 * result + (this.connection != null ? this.connection.hashCode() : 0);
            result = 31 * result + (this.count != null ? this.count.hashCode() : 0);
            result = 31 * result + (this.dependsOn != null ? this.dependsOn.hashCode() : 0);
            result = 31 * result + (this.forEach != null ? this.forEach.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.provider != null ? this.provider.hashCode() : 0);
            result = 31 * result + (this.provisioners != null ? this.provisioners.hashCode() : 0);
            return result;
        }
    }
}
