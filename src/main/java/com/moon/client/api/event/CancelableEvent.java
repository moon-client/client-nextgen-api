package com.moon.client.api.event;

import lombok.Getter;
import lombok.Setter;

/**
 * Provides the same marking ability as the {@link Event} class with a built-in
 * cancel action state.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
@Getter
@Setter
public class CancelableEvent extends Event {
    private boolean canceled;
}
