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

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A property is a configurable value of a dynamically definable type.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public abstract class Property<T, C extends PropertyConstraints, O extends PropertyChangeObserver<?, ?>> {
    protected final PropertyMetadata metadata;
    protected final C constraints;
    protected final O observer;
    protected T value;

    public abstract void value(T value);

    /**
     * Creates a basic json object for serialization used to serialize the entire property.
     *
     * @return The basic object
     * @since 1.0.0
     */
    protected JsonObject createBasicObject() {
        JsonObject object = new JsonObject();
        object.addProperty("id", metadata.id());
        return object;
    }

    /**
     * Serializes the property into a {@link JsonObject}.
     *
     * @return The serialized json object
     * @since 1.0.0
     */
    public abstract JsonObject serialize();

    /**
     * Deserializes the property using a {@link JsonObject}
     *
     * @param object The json object to deserialize
     * @since 1.0.0
     */
    public abstract void deserialize(JsonObject object);
}
