package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_certificates;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.256Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudCertificates.DataHcloudCertificatesCertificates")
@software.amazon.jsii.Jsii.Proxy(DataHcloudCertificatesCertificates.Jsii$Proxy.class)
public interface DataHcloudCertificatesCertificates extends software.amazon.jsii.JsiiSerializable {

    /**
     * @return a {@link Builder} of {@link DataHcloudCertificatesCertificates}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DataHcloudCertificatesCertificates}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DataHcloudCertificatesCertificates> {

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DataHcloudCertificatesCertificates}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DataHcloudCertificatesCertificates build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link DataHcloudCertificatesCertificates}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DataHcloudCertificatesCertificates {

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final Builder builder) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();


            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("hcloud.dataHcloudCertificates.DataHcloudCertificatesCertificates"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }
    }
}
