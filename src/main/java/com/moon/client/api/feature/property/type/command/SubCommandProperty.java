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
package com.moon.client.api.feature.property.type.command;

import com.google.gson.JsonObject;
import com.moon.client.api.feature.property.Property;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.PropertyMetadata;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import com.moon.client.api.feature.type.CommandFeature;
import org.jetbrains.annotations.Nullable;

/**
 * Property exclusively usable in the {@link CommandFeature}.
 * Defines a sub-command identified / executable by a defined id.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class SubCommandProperty extends Property<CommandFeature, EmptyPropertyConstraints, PropertyChangeObserver<Object, Object>> {
    public SubCommandProperty(PropertyMetadata metadata,
                              EmptyPropertyConstraints constraints,
                              PropertyChangeObserver<Object, Object> observer) {
        super(metadata, constraints, observer);
    }

    @Override
    public void value(CommandFeature value) {
    }

    @Override
    public @Nullable JsonObject serialize() {
        return null;
    }

    @Override
    public void deserialize(JsonObject object) {
    }
}
