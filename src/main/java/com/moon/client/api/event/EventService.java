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
package com.moon.client.api.event;

import com.moon.client.api.service.Service;

/**
 * Provides a very simple event bus implementation.
 *
 * <p>Defining subscriptions</p>
 * To define a subscription the {@link Subscribe} annotation has to be placed on a method inside
 * an object that is being registered.
 * <p>
 * The method that is marked as a callback must only contain <b>one</b> parameter which is the type of
 * event to create a callback for.
 *
 * <p>Example usage</p>
 * <pre>
 * {@code
 * import com.moon.client.api.event.Subscribe;
 *
 * public class ExampleSubscription {
 *     @Subscribe
 *     public void onTestCallback(ExampleEvent event) {
 *          // Your code goes here
 *     }
 * }
 * }
 * </pre>
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface EventService extends Service {
    /**
     * Registers all subscriptions (methods) in the given target object.
     *
     * @param target Target object
     * @since 1.0.0
     */
    void registerSubscriptions(Object target);

    /**
     * Removes all previously made subscriptions for the given target object.
     *
     * @param target Target object
     * @since 1.0.0
     */
    void unregisterSubscriptions(Object target);

    /**
     * Publishes an event to all callbacks subscribing to it.
     *
     * @param event Event object
     * @since 1.0.0
     */
    void publish(Event event);
}
