package com.moon.client.api.feature.property.builder;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.PropertyEnum;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import com.moon.client.api.feature.property.type.EnumProperty;

public class EnumPropertyBuilder<T extends Enum<T> & PropertyEnum> extends SimplePropertyBuilder<T, EmptyPropertyConstraints, PropertyChangeObserver<T, T>, EnumProperty<T>> {
    private final Class<T> clazz;

    public EnumPropertyBuilder(Configurable target, Class<T> clazz) {
        super(target);
        this.clazz = clazz;
    }

    @Override
    public EnumProperty<T> build() {
        // Invalid builder
        if (metadata == null || clazz == null || target == null) {
            throw new IllegalArgumentException("Incomplete builder, metadata, clazz, target must not be null");
        }

        EnumProperty<T> property = new EnumProperty<>(metadata, constraints, observer, clazz);
        target.addProperty(property);
        return property;
    }
}
