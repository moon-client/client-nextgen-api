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
package com.moon.client.api.service;

/**
 * Services expose publicly accessible APIs used to execute internal functionality.
 * <p>
 * Every service should have a base class that can be implemented to define the required functionality.
 * It is not recommended to directly implement the Service class into the implementation of a service.
 * There should always be a high-level api interface.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface Service {
}
