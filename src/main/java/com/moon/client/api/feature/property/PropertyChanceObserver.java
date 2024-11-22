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

/**
 * Used to listen to property changes on runtime.
 * <p>
 * As some property types might be multi-select (for example a combo-box) the observer types have to be
 * dynamically definable.
 * This adds a lot of type complexity but this complexity is not visible while using the property api.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface PropertyChanceObserver<O, N> {
    /**
     * Called on property value change.
     *
     * @param oldState The old value state
     * @param newState The new value state
     * @author lennoxlotl
     * @since 1.0.0
     */
    void observe(O oldState, N newState);
}
