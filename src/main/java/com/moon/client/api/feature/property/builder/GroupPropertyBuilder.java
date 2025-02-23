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
import com.moon.client.api.feature.property.Property;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import com.moon.client.api.feature.property.type.GroupProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupPropertyBuilder extends SimplePropertyBuilder<List<Property<?, ?, ?>>, EmptyPropertyConstraints, PropertyChangeObserver<Object, Object>, GroupProperty> {
    private final List<Property<?, ?, ?>> members = new ArrayList<>();

    public GroupPropertyBuilder(Configurable target) {
        super(target);
    }

    public GroupPropertyBuilder withMembers(Property<?, ?, ?>... members) {
        Arrays.stream(members)
                .forEach(property -> {
                    property.grouped(true);
                    this.members.add(property);
                });
        this.members.addAll(Arrays.stream(members).toList());
        return this;
    }

    @Override
    public GroupProperty build() {
        // Invalid builder
        if (metadata == null || target == null) {
            throw new IllegalArgumentException("Incomplete builder, metadata, target must not be null");
        }

        // Constraints and observers not supported
        GroupProperty property = new GroupProperty(metadata, null, null);
        property.visibility(visibility);
        property.value(members);
        target.addProperty(property);
        return property;
    }
}