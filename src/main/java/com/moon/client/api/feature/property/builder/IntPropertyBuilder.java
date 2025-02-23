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
package com.moon.client.api.feature.property.builder;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.constraint.NumberPropertyConstraints;
import com.moon.client.api.feature.property.type.number.IntProperty;

public class IntPropertyBuilder extends SimplePropertyBuilder<Integer, NumberPropertyConstraints<Integer>, PropertyChangeObserver<Integer, Integer>, IntProperty> {
    public IntPropertyBuilder(Configurable target) {
        super(target);
    }

    public IntProperty build() {
        // Invalid builder
        if (metadata == null || constraints == null || target == null) {
            throw new IllegalArgumentException("Incomplete builder, metadata, constraints, target must not be null");
        }
        // Invalid constraints
        if (constraints.min() >= constraints.max()) {
            throw new IllegalArgumentException("Invalid constraint, min is not allowed to be above or equal max");
        }
        if (constraints.steps() > constraints.max()) {
            throw new IllegalArgumentException("Invalid constraint, steps is not allowed to be above or equal max");
        }

        IntProperty property = new IntProperty(metadata, constraints, observer);
        property.value(defaultValue);
        target.addProperty(property);
        return property;
    }
}