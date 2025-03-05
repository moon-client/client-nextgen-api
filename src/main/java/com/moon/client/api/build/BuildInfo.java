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

import lombok.Builder;
import lombok.Data;

/**
 * Contains build information about the currently running application (client).
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Data
@Builder
public class BuildInfo {
    private final String branch;
    private final String version;
    private final String commitId;
    private final String commitIdAbbreviation;
    private final String time;
    private final int commitCount;
}
