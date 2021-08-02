package org.aktin.dwh;

import java.util.List;
import java.util.Map;

public interface SystemStatusManager {

    /**
     * @return get the version of a given linux package
     */
    String getLinuxPackageVersion(String aptPackage);

    /**
     * get the version of multiple linux packages at once
     *
     * @param list_packages list of linux packages
     * @return Map with {package_name, package_version}
     */
    Map<String, String> getLinuxPackagesVersion(List<String> list_packages);
}
