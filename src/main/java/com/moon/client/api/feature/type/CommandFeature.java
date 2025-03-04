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
package com.moon.client.api.feature.type;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.Executable;
import com.moon.client.api.feature.Feature;
import com.moon.client.api.feature.FeatureMetadata;
import com.moon.client.api.feature.property.Property;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Command features provide functionality configured and executed using user text input.
 *
 * <p>Defining arguments</p>
 * Command arguments are defined using the {@link Property} system / {@link Configurable} interface.
 * <p>
 * The defined properties are then translated to brigadier syntax on runtime (for auto-completion).
 * Not all argument types might be supported due to limitations with brigadier (e.g. group properties).
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public abstract class CommandFeature implements Feature, Executable, Configurable {
    @Getter
    private final List<Property<?, ?, ?>> properties = new ArrayList<>();
    private final FeatureMetadata metadata;

    protected CommandFeature(FeatureMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String id() {
        return metadata.id();
    }

    @Override
    public String name() {
        return metadata.name();
    }

    @Override
    public String description() {
        return metadata.description();
    }

    @Override
    public void addProperty(Property<?, ?, ?> property) {
        properties.add(property);
    }
}
