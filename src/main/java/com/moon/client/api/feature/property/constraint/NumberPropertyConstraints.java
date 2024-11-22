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
package com.moon.client.api.feature.property.constraint;

import com.moon.client.api.feature.property.PropertyConstraints;

/**
 * Unified constraint class for all number property types.
 *
 * @param <T> The number type (e.g. Integer, Float, ...)
 * @author lennoxlotl
 * @since 1.0.0
 */
public record NumberPropertyConstraints<T extends Number>(T min, T max, T steps) implements PropertyConstraints {
    public static <T extends Number> NumberPropertyConstraints<T> of(T min, T max, T steps) {
        return new NumberPropertyConstraints<>(min, max, steps);
    }
}
