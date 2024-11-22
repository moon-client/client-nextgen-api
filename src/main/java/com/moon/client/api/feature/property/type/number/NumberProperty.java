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
package com.moon.client.api.feature.property.type.number;

import com.moon.client.api.feature.property.Property;
import com.moon.client.api.feature.property.PropertyChanceObserver;
import com.moon.client.api.feature.property.PropertyMetadata;
import com.moon.client.api.feature.property.constraint.NumberPropertyConstraints;
import lombok.Getter;

/**
 * The template property for all number properties.
 * <p>
 * Contains a raw value for usage in ui development (proper sliders)
 *
 * @param <T> The type of number
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
abstract class NumberProperty<T extends Number> extends Property<T, NumberPropertyConstraints<T>, PropertyChanceObserver<T, T>> {
    protected static final int PLACES_COUNT = 3;
    protected T rawValue;

    public NumberProperty(PropertyMetadata metadata, NumberPropertyConstraints<T> constraints, PropertyChanceObserver<T, T> observer) {
        super(metadata, constraints, observer);
    }

    /**
     * Rounds a value down to a given amount of places.
     *
     * @param value  The value
     * @param places The places (numbers after the .)
     * @return The rounded value
     */
    protected double round(double value, int places) {
        double rounding = Math.pow(10, places);
        return Math.round(value * rounding) / rounding;
    }
}
