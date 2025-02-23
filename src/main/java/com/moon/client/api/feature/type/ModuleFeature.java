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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.moon.client.api.feature.*;
import com.moon.client.api.feature.binding.BindingInputDevice;
import com.moon.client.api.feature.binding.BindingTriggerStrategy;
import com.moon.client.api.feature.property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Module features provide toggleable functionality to the client.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class ModuleFeature implements Feature, Bindable, Configurable, Serializable, Toggleable {
    private final List<Property<?, ?, ?>> properties = new ArrayList<>();
    private final FeatureMetadata metadata;
    private BindingInputDevice inputDevice;
    private BindingTriggerStrategy inputTriggerStrategy;
    private int inputKey = -1;
    private boolean toggled;

    public ModuleFeature(FeatureMetadata metadata) {
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
    public void enable() {
    }

    @Override
    public void disable() {
    }

    @Override
    public void toggle() {
        setToggled(!isToggled());
    }

    @Override
    public boolean isToggled() {
        return toggled;
    }

    @Override
    public void setToggled(boolean value) {
        this.toggled = value;
        // TODO: Implement event service once available
        if (toggled) {
            enable();
        } else {
            disable();
        }
    }

    @Override
    public JsonObject serialize() {
        JsonObject moduleObject = new JsonObject();
        moduleObject.addProperty("id", id());

        // Some modules may not be bound, saves space
        if (inputKey != -1) {
            moduleObject.addProperty("device", inputDevice.ordinal());
            moduleObject.addProperty("trigger", inputTriggerStrategy.ordinal());
            moduleObject.addProperty("key", inputKey);
        }

        // Some modules might not have properties, saves space
        if (!properties.isEmpty()) {
            JsonArray propertiesArray = new JsonArray();
            for (Property<?, ?, ?> property : properties) {
                JsonObject serializedProperty = property.serialize();
                // Some properties like group properties don't implement serialization
                if (serializedProperty != null) {
                    propertiesArray.add(serializedProperty);
                }
            }
            moduleObject.add("properties", propertiesArray);
        }

        return moduleObject;
    }

    @Override
    public void deserialize(JsonObject json) {
        if (json.has("key")) {
            inputKey = json.get("key").getAsInt();
            // This should be fine, we will usually not remove input devices or strategies
            inputDevice = BindingInputDevice.values()[json.get("device").getAsInt()];
            inputTriggerStrategy = BindingTriggerStrategy.values()[json.get("trigger").getAsInt()];
        }

        if (json.has("properties")) {
            JsonArray propertiesArray = json.get("properties").getAsJsonArray();
            for (JsonElement jsonElement : propertiesArray) {
                JsonObject propertyObject = jsonElement.getAsJsonObject();
                String id = propertyObject.get("id").getAsString();
                properties.stream()
                    .filter(property -> property.metadata().id().equals(id))
                    .findFirst()
                    .ifPresent(property -> property.deserialize(propertyObject));
            }
        }
    }

    @Override
    public void addProperty(Property<?, ?, ?> property) {
        properties.add(property);
    }

    @Override
    public void onPressed() {
        toggle();
    }

    @Override
    public BindingInputDevice inputDevice() {
        return inputDevice;
    }

    @Override
    public BindingTriggerStrategy inputTriggerStrategy() {
        return inputTriggerStrategy;
    }

    @Override
    public int inputKey() {
        return inputKey;
    }

    @Override
    public void setInputDevice(BindingInputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }

    @Override
    public void setInputTriggerStrategy(BindingTriggerStrategy inputTriggerStrategy) {
        this.inputTriggerStrategy = inputTriggerStrategy;
    }

    @Override
    public void setInputKey(int inputKey) {
        this.inputKey = inputKey;
    }
}
