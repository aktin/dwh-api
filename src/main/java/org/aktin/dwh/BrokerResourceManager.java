package org.aktin.dwh;

import java.util.Map;

/**
 * Collect diverse resources from DWH and sent them to the AKTIN Broker
 * Resources are external dependencies, such as a required linux package or a postgresql database
 * All ressources are defined as (name of resource) : (version of resource)
 */
public interface BrokerResourceManager {

    /**
     * put new resource group of this broker-client on the AKTIN Broker
     */
    void putResourceGroup(String name, Map<String, String> resources);

    /**
     * get the version of a given linux package
     */
    String getLinuxPackageVersion(String package_apt);

    /**
     * get the version of the used application server
     */
    String getApplicationServerVersion();

    /**
     * get the version of the used database
     */
    String getDatabaseVersion();

    /*
     * get the version of apache server
     */
    String getApacheVersion();

    /**
     * get the version of the used dwhj2ee
     */
    String getDwhVersion();

    /**
     * get the version of the used dwh-api
     */
    String getDwhApiVersion();

    /**
     * get the used java version
     */
    String getJavaVersion();
}
