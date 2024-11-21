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
package com.moon.client.api.feature;

import com.moon.client.api.feature.binding.BindingInputDevice;
import com.moon.client.api.feature.binding.BindingTriggerStrategy;
import org.lwjgl.glfw.GLFW;

/**
 * Makes a feature bindable.
 * <p>
 * Bindings are represented by a keyboard or mouse button being pressed, held or invoked
 * in other ways.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface Bindable {
    /**
     * Called once the bindable is triggered.
     *
     * @since 1.0.0
     */
    void onPressed();

    /**
     * Returns the input device used for triggering the bindable.
     *
     * @return Input device
     * @since 1.0.0
     */
    BindingInputDevice getInputDevice();

    /**
     * Returns the trigger strategy used to identify when to trigger a bindable.
     *
     * @return Trigger strategy
     * @since 1.0.0
     */
    BindingTriggerStrategy getInputTriggerStrategy();

    /**
     * Returns the key used for triggering the bindable.
     * <p>
     * Depending on the input device the format of this key is different.
     * <ul>
     * <li>For {@link BindingInputDevice#KEYBOARD} the value will be in the format of {@link GLFW} keys</li>
     * <li>For {@link BindingInputDevice#MOUSE} the value will represent the index of the button used</li>
     * </ul>
     *
     * @return Input key value
     * @since 1.0.0
     */
    int getInputKey();
}
