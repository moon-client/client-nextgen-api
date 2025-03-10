package com.moon.client.api.feature.property.constraint;

import com.moon.client.api.feature.property.PropertyConstraints;

/**
 * Limits what string properties are allowed to contain.
 *
 * @param word Only allowed to consist of one word
 * @author lennoxlotl
 * @since 1.0.0
 */
public record StringPropertyConstraints(boolean word) implements PropertyConstraints {
}
