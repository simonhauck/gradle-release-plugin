package com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.data_hcloud_ssh_keys;

@javax.annotation.Generated(value = "jsii-pacmak/1.93.0 (build 1706ca5)", date = "2024-01-28T13:37:41.322Z")
@software.amazon.jsii.Jsii(module = com.github.cryptojuenger.template.infrastructure.hcloudprovider.hcloud.$Module.class, fqn = "hcloud.dataHcloudSshKeys.DataHcloudSshKeysSshKeys")
@software.amazon.jsii.Jsii.Proxy(DataHcloudSshKeysSshKeys.Jsii$Proxy.class)
public interface DataHcloudSshKeysSshKeys extends software.amazon.jsii.JsiiSerializable {

    /**
     * @return a {@link Builder} of {@link DataHcloudSshKeysSshKeys}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DataHcloudSshKeysSshKeys}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DataHcloudSshKeysSshKeys> {

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DataHcloudSshKeysSshKeys}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DataHcloudSshKeysSshKeys build() {
            return new Jsii$Proxy(this);
        }
    }

    /**
     * An implementation for {@link DataHcloudSshKeysSshKeys}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DataHcloudSshKeysSshKeys {

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
            struct.set("fqn", om.valueToTree("hcloud.dataHcloudSshKeys.DataHcloudSshKeysSshKeys"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }
    }
}
