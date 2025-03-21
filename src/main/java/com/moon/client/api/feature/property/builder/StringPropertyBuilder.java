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
import com.moon.client.api.feature.property.constraint.StringPropertyConstraints;
import com.moon.client.api.feature.property.type.StringProperty;

public class StringPropertyBuilder extends SimplePropertyBuilder<String, StringPropertyConstraints, PropertyChangeObserver<String, String>, StringProperty> {
    public StringPropertyBuilder(Configurable target) {
        super(target);
    }

    @Override
    public StringProperty build() {
        // Invalid builder
        if (metadata == null || target == null) {
            throw new IllegalArgumentException("Incomplete builder, metadata, target must not be null");
        }

        StringProperty property = new StringProperty(metadata, constraints, observer);
        property.value(defaultValue);
        target.addProperty(property);
        return property;
    }
}