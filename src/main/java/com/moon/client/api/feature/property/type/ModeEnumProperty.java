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
import com.moon.client.api.feature.Feature;
import com.moon.client.api.feature.property.*;
import com.moon.client.api.feature.property.builder.ModeEnumPropertyBuilder;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * Property used for selecting a mode feature from a {@link PropertyEnum} and {@link PropertyMode}.
 *
 * @param <T> The enum type containing all modes
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
public class ModeEnumProperty<T extends Enum<T> & PropertyEnum & PropertyMode<?>> extends Property<T, EmptyPropertyConstraints, PropertyChangeObserver<T, T>> {
    private final Feature feature;
    private final List<T> constants;

    public ModeEnumProperty(PropertyMetadata metadata,
                            EmptyPropertyConstraints constraints,
                            PropertyChangeObserver<T, T> observer,
                            Feature feature,
                            Class<T> clazz) {
        super(metadata, constraints, observer);
        this.feature = feature;
        this.constants = Arrays.stream(clazz.getEnumConstants()).toList();
    }

    @Override
    public void value(T value) {
        // TODO: Handle toggleable, event service required
        this.value = value;
    }

    @Override
    public JsonObject serialize() {
        JsonObject object = createBasicObject();
        object.addProperty("value", value.id());
        return object;
    }

    @Override
    public void deserialize(JsonObject object) {
        String id = object.get("value").getAsString();
        T value = constants.stream()
            .filter(constant -> constant.id().equals(id))
            .findFirst()
            .orElse(null);
        // Enum constants can always be deleted, therefore this shouldn't cause any major error
        if (value != null) {
            this.value = value;
        }
    }

    public static <T extends Enum<T> & PropertyEnum & PropertyMode<?>> ModeEnumPropertyBuilder<T> builder(Configurable target, Class<T> clazz, Feature feature) {
        return new ModeEnumPropertyBuilder<>(target, clazz, feature);
    }
}
