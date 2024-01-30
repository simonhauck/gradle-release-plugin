package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_locations;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.305Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudLocations.DataHcloudLocationsLocations")
@software.amazon.jsii.Jsii.Proxy(DataHcloudLocationsLocations.Jsii$Proxy.class)
public interface DataHcloudLocationsLocations extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/locations#id DataHcloudLocations#id}.
     * <p>
     * Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
     * If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getId() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/locations#name DataHcloudLocations#name}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DataHcloudLocationsLocations}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DataHcloudLocationsLocations}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DataHcloudLocationsLocations> {
        java.lang.Number id;
        java.lang.String name;

        /**
         * Sets the value of {@link DataHcloudLocationsLocations#getId}
         * @param id Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/locations#id DataHcloudLocations#id}.
         *           Please be aware that the id field is automatically added to all resources in Terraform providers using a Terraform provider SDK version below 2.
         *           If you experience problems setting this value it might not be settable. Please take a look at the provider documentation to ensure it should be settable.
         * @return {@code this}
         */
        public Builder id(java.lang.Number id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the value of {@link DataHcloudLocationsLocations#getName}
         * @param name Docs at Terraform Registry: {@link https://registry.terraform.io/providers/hetznercloud/hcloud/1.45.0/docs/data-sources/locations#name DataHcloudLocations#name}.
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DataHcloudLocationsLocations}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DataHcloudLocationsLocations build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link DataHcloudLocationsLocations}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DataHcloudLocationsLocations {
        private final java.lang.Number id;
        private final java.lang.String name;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.id = software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.id = builder.id;
            this.name = builder.name;
        }

        @Override
        public final java.lang.Number getId() {
            return this.id;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getId() != null) {
                data.set("id", om.valueToTree(this.getId()));
            }
            if (this.getName() != null) {
                data.set("name", om.valueToTree(this.getName()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.dataHcloudLocations.DataHcloudLocationsLocations"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataHcloudLocationsLocations.Jsii$Proxy that = (DataHcloudLocationsLocations.Jsii$Proxy) o;

            if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
            return this.name != null ? this.name.equals(that.name) : that.name == null;
        }

        @Override
        public final int hashCode() {
            int result = this.id != null ? this.id.hashCode() : 0;
            result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
            return result;
        }
    }
}
