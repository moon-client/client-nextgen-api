/*
 * client-nextgen-api
 * Copyright (C) 2024 Moon Client
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
package com.moon.client.api.feature;

import com.moon.client.api.service.Service;

/**
 * Public access to the feature api.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface FeatureService extends Service {
    /**
     * Registers a feature in the responsible repository.
     *
     * @param feature Feature instance
     * @since 1.0.0
     */
    void register(Feature feature);

    /**
     * Finds a feature in the responsible repository by the features class.
     *
     * @param feature Feature class
     * @param <T>     Feature type
     * @return Feature instance or null
     * @since 1.0.0
     */
    <T extends Feature> T find(Class<? extends Feature> feature);

    /**
     * Finds a feature in the responsible repository by the feature id.
     *
     * @param id  Feature id
     * @param <T> Feature type
     * @return Feature instance or null
     * @since 1.0.0
     */
    <T extends Feature> T find(String id);
}
