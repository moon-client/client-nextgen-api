package com.moon.client.api.build;

import com.moon.client.api.service.Service;

/**
 * Generates information about the current client build.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface BuildInfoService extends Service {
    /**
     * Derives build information from the git.properties file inside the JAR-resources.
     *
     * @return Git BuildInfo
     * @since 1.0.0
     */
    BuildInfo git();

    /**
     * Generates stub build information.
     *
     * @return Stub BuildInfo
     * @since 1.0.0
     */
    BuildInfo empty();
}
