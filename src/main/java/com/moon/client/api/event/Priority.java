package com.moon.client.api.event;

/**
 * Allows a priority for an event subscription to be set.
 * <p>
 * Subscriptions with HIGHEST are called first and LOWEST last.
 *
 * @author lennoxlotl
 */
public enum Priority {
    HIGHEST,
    HIGH,
    NORMAL,
    LOW,
    LOWEST;
}
