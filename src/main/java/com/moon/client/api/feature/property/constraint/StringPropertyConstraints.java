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
package com.moon.client.api.feature.property.constraint;

import com.moon.client.api.feature.property.PropertyConstraints;

/**
 * Limits what string properties are allowed to contain.
 *
 * @param word Only allowed to consist of one word
 * @author lennoxlotl
 * @since 1.0.0
 */
public record StringPropertyConstraints(boolean word) implements PropertyConstraints {
    public static StringPropertyConstraints of(boolean word) {
        return new StringPropertyConstraints(word);
    }
}
