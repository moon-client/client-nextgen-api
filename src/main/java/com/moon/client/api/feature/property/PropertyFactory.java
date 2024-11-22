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
package com.moon.client.api.feature.property;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.Feature;
import com.moon.client.api.feature.property.builder.EnumPropertyBuilder;
import com.moon.client.api.feature.property.builder.FloatPropertyBuilder;
import com.moon.client.api.feature.property.builder.IntPropertyBuilder;
import com.moon.client.api.feature.property.builder.StringPropertyBuilder;
import com.moon.client.api.feature.property.type.EnumProperty;
import com.moon.client.api.feature.property.type.number.FloatProperty;
import com.moon.client.api.feature.property.type.number.IntProperty;
import com.moon.client.api.feature.property.type.StringProperty;

/**
 * Used to create properties linked to {@link Configurable} {@link Feature}s.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class PropertyFactory {
    public static IntPropertyBuilder intBuilder(Configurable target) {
        return IntProperty.builder(target);
    }

    public static FloatPropertyBuilder floatBuilder(Configurable target) {
        return FloatProperty.builder(target);
    }

    public static StringPropertyBuilder stringBuilder(Configurable target) {
        return StringProperty.builder(target);
    }

    public static <T extends Enum<T> & PropertyEnum> EnumPropertyBuilder<T> enumBuilder(Configurable target, Class<T> clazz) {
        return EnumProperty.builder(target, clazz);
    }
}
