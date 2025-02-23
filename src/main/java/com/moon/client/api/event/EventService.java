package com.moon.client.api.event;

import com.moon.client.api.service.Service;

/**
 * Provides a very simple event bus implementation.
 *
 * <h1>Defining subscriptions</h1>
 * To define a subscription the {@link Subscribe} annotation has to be placed on a method inside
 * an object that is being registered.
 * <p>
 * The method that is marked as a callback must only contain <b>one</b> parameter which is the type of
 * event to create a callback for.
 *
 * <h3>Example usage</h3>
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
