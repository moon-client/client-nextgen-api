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
import com.moon.client.api.feature.property.builder.GroupPropertyBuilder;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;

import java.util.List;

/**
 * Property used to create groups of properties.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class GroupProperty extends Property<List<Property<?, ?, ?>>, EmptyPropertyConstraints, PropertyChangeObserver<Object, Object>> {
    public GroupProperty(PropertyMetadata metadata,
                         EmptyPropertyConstraints constraints,
                         PropertyChangeObserver<Object, Object> observer) {
        super(metadata, constraints, observer);
    }

    @Override
    public void value(List<Property<?, ?, ?>> value) {
        if (this.value != null) {
            throw new IllegalStateException("Group property members cannot be manually updated");
        }
        this.value = value;
    }

    @Override
    public JsonObject serialize() {
        return null;
    }

    @Override
    public void deserialize(JsonObject object) {
    }

    public static GroupPropertyBuilder builder(Configurable target) {
        return new GroupPropertyBuilder(target);
    }
}
