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
