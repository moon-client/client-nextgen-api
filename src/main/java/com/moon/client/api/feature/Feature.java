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
package com.moon.client.api.feature;

/**
 * Provides different types of functionality inside the client.
 * <p>
 * <p>
 * Features can implement attributes which expand its scope in different ways:
 * <ul>
 * <li>A feature can be made {@link Configurable} to allow for user configuration.</li>
 * <li>A feature can be made {@link Serializable} to save its state after client closure.</li>
 * <li>A feature can be made {@link Toggleable} to provide functionality if a "toggled" / activated
 * state is true.</li>
 * <li>A feature can be made {@link Executable} to allow execution through a chat-box or other input types.</li>
 * <li>A feature can be made {@link Bindable} to allow execution on a keyboard or mouse button press</li>
 * </ul>
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface Feature {
    /**
     * Returns a strictly unique feature id that should not change throughout
     * the lifetime of the feature (inside and outside of runtime).
     * <p>
     * Could be displayed to the user but usually won't.
     * <p>
     * <p>
     * As features can be {@link Configurable} several policies must be complied with:
     * <p>
     * The id should match the following regex: "^[^\\\\/:*?\&quot;&lt;&gt;|\\x00-\\x1F]+$".
     * This will ensure compliance with the Windows file-system (which is quite harsh with file names).
     * Other forbidden ids include but are not exclusive to: "(?i)^(CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])(\\..*)?$".
     * These file names aren't allowed to be created under the Windows file system.
     *
     * @return Unique feature id
     * @since 1.0.0
     */
    String id();

    /**
     * Returns a display name locale key, will be displayed to the user.
     *
     * @return Locale key (i18n)
     * @apiNote Locale implementation will display locale key if translation is not found
     * @since 1.0.0
     */
    String name();

    /**
     * Returns a description locale key, will be displayed to the user.
     *
     * @return Locale key (i18n)
     * @apiNote Locale implementation will display locale key if translation is not found
     * @since 1.0.0
     */
    String description();
}
