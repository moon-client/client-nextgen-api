package com.moon.client.api.feature.property.type;

import com.google.gson.JsonObject;
import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.Property;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.PropertyEnum;
import com.moon.client.api.feature.property.PropertyMetadata;
import com.moon.client.api.feature.property.builder.EnumPropertyBuilder;
import com.moon.client.api.feature.property.constraint.EmptyPropertyConstraints;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * Property used for selection of a {@link Enum} type (list).
 *
 * @param <T> The enum type
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
public class EnumProperty<T extends Enum<T> & PropertyEnum> extends Property<T, EmptyPropertyConstraints, PropertyChangeObserver<T, T>> {
    private final List<T> constants;

    public EnumProperty(PropertyMetadata metadata,
                        EmptyPropertyConstraints constraints,
                        PropertyChangeObserver<T, T> observer,
                        Class<T> clazz) {
        super(metadata, constraints, observer);
        this.constants = Arrays.stream(clazz.getEnumConstants()).toList();
    }

    @Override
    public void value(T value) {
        if (observer != null) {
            observer.observe(this.value, value);
        }

        this.value = value;
    }

    @Override
    public JsonObject serialize() {
        JsonObject object = createBasicObject();
        object.addProperty("value", value.id());
        return object;
    }

    @Override
    public void deserialize(JsonObject object) {
        String id = object.get("value").getAsString();
        T value = constants.stream()
            .filter(constant -> constant.id().equals(id))
            .findFirst()
            .orElse(null);
        // Enum constants can always be deleted, therefore this shouldn't cause any major error
        if (value != null) {
            this.value = value;
        }
    }

    public static <T extends Enum<T> & PropertyEnum> EnumPropertyBuilder<T> builder(Configurable target, Class<T> clazz) {
        return new EnumPropertyBuilder<>(target, clazz);
    }
}
