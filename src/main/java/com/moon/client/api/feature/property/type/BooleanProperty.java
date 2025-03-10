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
package com.moon.client.api.feature.property.type;

import com.google.gson.JsonObject;
import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.Property;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.PropertyMetadata;
import com.moon.client.api.feature.property.builder.BooleanPropertyBuilder;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import org.jetbrains.annotations.Nullable;

/**
 * Property for {@link Boolean} property types.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class BooleanProperty extends Property<Boolean, EmptyPropertyConstraints, PropertyChangeObserver<Boolean, Boolean>> {
    public BooleanProperty(PropertyMetadata metadata,
                           EmptyPropertyConstraints constraints,
                           PropertyChangeObserver<Boolean, Boolean> observer) {
        super(metadata, constraints, observer);
    }

    @Override
    public void value(Boolean value) {
        if (observer != null) {
            observer.observe(this.value, value);
        }

        this.value = value;
    }

    @Override
    public @Nullable JsonObject serialize() {
        JsonObject object = createBasicObject();
        object.addProperty("value", value);
        return object;
    }

    @Override
    public void deserialize(JsonObject object) {
        value = object.get("value").getAsBoolean();
    }

    public static BooleanPropertyBuilder builder(Configurable target) {
        return new BooleanPropertyBuilder(target);
    }
}
