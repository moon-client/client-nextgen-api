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
package com.moon.client.api.feature.property.builder;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.PropertyChanceObserver;
import com.moon.client.api.feature.property.constraint.NumberPropertyConstraints;
import com.moon.client.api.feature.property.type.number.IntProperty;

public class IntPropertyBuilder extends SimplePropertyBuilder<Integer, NumberPropertyConstraints<Integer>, PropertyChanceObserver<Integer, Integer>, IntProperty> {
    public IntPropertyBuilder(Configurable target) {
        super(target);
    }

    public IntProperty build() {
        if (incomplete()) {
            throw new IllegalArgumentException("Incomplete builder, metadata, constraints, target must not be null");
        }
        IntProperty property = new IntProperty(metadata, constraints, observer);
        target.addProperty(property);
        return property;
    }
}