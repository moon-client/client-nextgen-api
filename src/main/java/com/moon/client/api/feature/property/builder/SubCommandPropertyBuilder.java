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
