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
package com.moon.client.api.feature.binding;

import com.moon.client.api.feature.Bindable;
import com.moon.client.api.feature.Feature;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines different mechanisms which control how a key has to be pressed for
 * a {@link Bindable} {@link Feature} to be triggered.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum BindingTriggerStrategy {
    /**
     * {@link Bindable} is triggered on a simple press of the button
     */
    PRESS((cur, prev) -> cur),
    /**
     * {@link Bindable} is triggered whenever a key is pressed or released (on state change)
     */
    HOLD((cur, prev) -> cur != prev);

    private final BindingKeyPressEvaluator evaluator;
}
