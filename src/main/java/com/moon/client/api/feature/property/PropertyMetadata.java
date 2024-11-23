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
package com.moon.client.api.feature.property;

/**
 * Defines required meta-data every property must have to be created.
 * <p>
 * This data is used for serialization, ui and other areas visible by the user,
 * therefore sensible data shall be provided here.
 *
 * @param id   The internal id of the property (must be and stay unique)
 * @param name The i18n key linking to the display-name of the property
 * @author lennoxlotl
 * @apiNote Locale implementation will display locale key if translation is not found
 * @since 1.0.0
 */
public record PropertyMetadata(String id, String name) {
    public static PropertyMetadata of(String id, String name) {
        return new PropertyMetadata(id, name);
    }
}
