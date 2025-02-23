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
package com.moon.client.api.feature.property.builder;

import com.moon.client.api.feature.Configurable;
import com.moon.client.api.feature.property.Property;
import com.moon.client.api.feature.property.PropertyChangeObserver;
import com.moon.client.api.feature.property.PropertyConstraints;
import com.moon.client.api.feature.property.PropertyMetadata;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

/**
 * Provides a basic builder template for simple property types (such as numbers).
 *
 * @param <T> The type the property will have (e.g. Integer, Float, String)
 * @param <C> The constraint type of the property
 * @param <O> The observer type
 * @param <P> The property type itself (what will be built)
 * @author lennoxlotl
 * @since 1.0.0
 */
@RequiredArgsConstructor
public abstract class SimplePropertyBuilder<T, C extends PropertyConstraints, O extends PropertyChangeObserver<?, ?>, P extends Property<T, C, O>> {
    protected final Configurable target;
    protected PropertyMetadata metadata;
    protected O observer;
    protected C constraints;
    protected Supplier<Boolean> visibility;

    public SimplePropertyBuilder<T, C, O, P> withMetadata(PropertyMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public SimplePropertyBuilder<T, C, O, P> withConstraints(C constraints) {
        this.constraints = constraints;
        return this;
    }

    public SimplePropertyBuilder<T, C, O, P> withObserver(O observer) {
        this.observer = observer;
        return this;
    }

    public SimplePropertyBuilder<T, C, O, P> withVisibility(Supplier<Boolean> visibility) {
        this.visibility = visibility;
        return this;
    }

    public abstract P build();
}
