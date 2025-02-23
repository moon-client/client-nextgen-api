package com.moon.client.api.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used on methods to mark a subscription callback.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {
    /**
     * Call-priority for event subscription.
     * <p>
     * All callbacks are sorted by the priority defined here.
     *
     * @return Event call priority
     * @since 1.0.0
     */
    Priority priority() default Priority.NORMAL;
}
