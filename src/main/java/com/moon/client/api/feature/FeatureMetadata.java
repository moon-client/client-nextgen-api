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
