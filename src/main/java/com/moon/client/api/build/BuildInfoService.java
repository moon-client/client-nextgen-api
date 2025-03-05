/*
 * client-nextgen-api
 * Copyright (C) 2024-2025 Moon Client
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
