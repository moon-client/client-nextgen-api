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
import com.moon.client.api.feature.property.type.number.FloatProperty;

public class FloatPropertyBuilder extends SimplePropertyBuilder<Float, NumberPropertyConstraints<Float>, PropertyChanceObserver<Float, Float>, FloatProperty> {
    public FloatPropertyBuilder(Configurable target) {
        super(target);
    }

    @Override
    public FloatProperty build() {
        FloatProperty property = new FloatProperty(metadata, constraints, observer);
        target.addProperty(property);
        return property;
    }
}