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
import com.moon.client.api.feature.property.builder.StringPropertyBuilder;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.regex.Pattern;

/**
 * Property used to represent {@link String} property types.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Setter
@Accessors(fluent = true)
public class StringProperty extends Property<String, EmptyPropertyConstraints, PropertyChangeObserver<String, String>> {
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    // If set only allows singular words to be set as value
    private boolean word;

    public StringProperty(PropertyMetadata metadata,
                          EmptyPropertyConstraints constraints,
                          PropertyChangeObserver<String, String> observer) {
        super(metadata, constraints, observer);
    }

    @Override
    public void value(String value) {
        // Don't allow whitespaces or newlines
        if (word && containsWhitespace(value)) {
            return;
        }

        if (observer != null) {
            observer.observe(this.value, value);
        }

        this.value = value;
    }

    @Override
    public JsonObject serialize() {
        JsonObject object = createBasicObject();
        object.addProperty("value", value);
        return object;
    }

    @Override
    public void deserialize(JsonObject object) {
        value = object.get("value").getAsString();
    }

    private boolean containsWhitespace(String input) {
        return WHITESPACE_PATTERN.matcher(input).find();
    }

    public static StringPropertyBuilder builder(Configurable target) {
        return new StringPropertyBuilder(target);
    }
}
