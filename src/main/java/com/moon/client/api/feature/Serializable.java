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

import com.google.gson.JsonObject;

/**
 * Makes a feature serializable.
 * <p>
 * Serializable features will automatically be saved on runtime and client closure.
 * It is automatically restored after client launch on feature registration.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface Serializable {
    /**
     * Serializes the feature state into a json object.
     *
     * @return The serialized state
     * @since 1.0.0
     */
    JsonObject serialize();

    /**
     * Deserializes the given state and applies it to the feature.
     *
     * @param json The serialized json object
     * @since 1.0.0
     */
    void deserialize(JsonObject json);
}
