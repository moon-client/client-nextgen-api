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
