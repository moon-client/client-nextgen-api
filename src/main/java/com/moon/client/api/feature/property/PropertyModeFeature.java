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
package com.moon.client.api.feature.property;

import com.moon.client.api.feature.Feature;
import com.moon.client.api.feature.Toggleable;
import lombok.RequiredArgsConstructor;

/**
 * Used to implement feature modes for {@link PropertyMode} mode selectors.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@RequiredArgsConstructor
public abstract class PropertyModeFeature<T extends Feature> implements Toggleable {
    private final Class<T> featureClazz;
    private T feature;

    public T feature() {
        checkFeatureAbsent();
        return feature;
    }

    /**
     * Makes sure the feature instance is available on runtime.
     *
     * @since 1.0.0
     */
    public void checkFeatureAbsent() {
        // TODO: implement once feature service is available
    }
}
