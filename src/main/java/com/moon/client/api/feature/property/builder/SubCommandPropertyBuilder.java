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
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import com.moon.client.api.feature.property.type.command.SubCommandProperty;
import com.moon.client.api.feature.type.CommandFeature;

public class SubCommandPropertyBuilder extends SimplePropertyBuilder<CommandFeature, EmptyPropertyConstraints, PropertyChangeObserver<Object, Object>, SubCommandProperty> {
    public SubCommandPropertyBuilder(Configurable target) {
        super(target);
    }

    @Override
    public SubCommandProperty build() {
        // Invalid builder
        if (metadata == null) {
            throw new IllegalArgumentException("Incomplete builder, metadata must not be null");
        }

        SubCommandProperty property = new SubCommandProperty(metadata, constraints, observer);
        target.addProperty(property);
        return property;
    }
}
