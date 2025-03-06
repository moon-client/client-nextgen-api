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
package com.moon.client.api.feature.property;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.builder.KeyInputPropertyBuilder;
import com.moon.client.api.feature.property.builder.SubCommandPropertyBuilder;
import com.moon.client.api.feature.property.type.command.KeyInputProperty;
import com.moon.client.api.feature.property.type.command.SubCommandProperty;
import com.moon.client.api.feature.type.CommandFeature;

/**
 * Used to create properties exclusive to {@link CommandFeature}s.
 * <p>
 * The reason this is seperated is to avoid confusion when creating properties for other feature types.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class CommandPropertyFactory {
    public static SubCommandPropertyBuilder subCommandBuilder(Configurable target) {
        return SubCommandProperty.builder(target);
    }

    public static KeyInputPropertyBuilder keyInputBuilder(Configurable target) {
        return KeyInputProperty.builder(target);
    }
}
