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

/**
 * Used to set the metadata of a {@link Feature}, it must comply with all policies defined
 * in the {@link Feature} class.
 *
 * @param id Feature id
 * @param name Feature name
 * @param description Feature description
 * @author lennoxlotl
 * @since 1.0.0
 */
public record FeatureMetadata(String id, String name, String description) {
    public static FeatureMetadata of(String id, String name, String description) {
        if (!id.matches("^(?!^(CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])(?:\\..*)?$)[^\\\\/:*?\"<>|]+$")) {
            throw new IllegalArgumentException("Invalid feature id %s, does not match required Regex".formatted(id));
        }
        return new FeatureMetadata(id, name, description);
    }
}
