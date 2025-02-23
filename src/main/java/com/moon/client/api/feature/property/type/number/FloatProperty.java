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
package com.moon.client.api.feature.property.type.number;

import com.google.gson.JsonObject;
import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.PropertyMetadata;
import com.moon.client.api.feature.property.builder.FloatPropertyBuilder;
import com.moon.client.api.feature.property.constraint.NumberPropertyConstraints;
import lombok.Getter;
import net.minecraft.util.math.MathHelper;

/**
 * Property used to represent {@link Float} java types.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
public class FloatProperty extends NumberProperty<Float> {
    public FloatProperty(PropertyMetadata metadata,
                         NumberPropertyConstraints<Float> constraints,
                         PropertyChangeObserver<Float, Float> observer) {
        super(metadata, constraints, observer);
    }

    @Override
    public void value(Float value) {
        float steps = constraints.steps();
        float clamped = MathHelper.clamp(value, constraints.min(), constraints.max());
        float rounded =
            (float) round(
                MathHelper.clamp(
                    steps * MathHelper.ceil(value / steps),
                    constraints.min(),
                    constraints.max()),
                PLACES_COUNT);

        if (observer != null) {
            observer.observe(this.value, rounded);
        }

        this.rawValue = clamped;
        this.value = rounded;
    }

    @Override
    public JsonObject serialize() {
        JsonObject object = createBasicObject();
        object.addProperty("value", value);
        return object;
    }

    @Override
    public void deserialize(JsonObject object) {
        value = object.get("value").getAsFloat();
    }

    public static FloatPropertyBuilder builder(Configurable target) {
        return new FloatPropertyBuilder(target);
    }
}
