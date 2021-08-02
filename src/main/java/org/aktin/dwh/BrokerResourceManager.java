package org.aktin.dwh;

import java.io.InputStream;
import java.util.Properties;

/**
 * interface to provide injecting classes resource handling functionality of broker-client
 */
public interface BrokerResourceManager {

    // upload a new resource group of given name to AKTIN broker
    void putMyResource(String name, String contentType, final InputStream content);

    void putMyResource(String name, String contentType, final String content);

    void putMyResourceProperties(final String name, final Properties properties);

    void putMyResourceXml(String name, final Object jaxbObject);

    // get a resource group of given name from AKTIN broker
    Properties getMyResourceProperties(String name);

    // delete a resource group from AKTIN broker
    void deleteMyResource(String name);
}
