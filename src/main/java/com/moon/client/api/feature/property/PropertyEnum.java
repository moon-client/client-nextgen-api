package com.moon.client.api.feature.property;

/**
 * Marks an enum as usable in properties.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface PropertyEnum {
    /**
     * The id of the enum value used for serialization purposes.
     *
     * @return Enum id
     * @since 1.0.0
     */
    String id();

    /**
     * Returns an i18n key linking to the display-name of the enum value
     *
     * @return Locale key (i18n)
     * @apiNote Locale implementation will display locale key if translation is not found
     * @since 1.0.0
     */
    String name();
}
