package com.moon.client.api.feature;

import com.moon.client.api.service.Service;

/**
 * Public access to the feature api.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public interface FeatureService extends Service {
    /**
     * Registers a feature in the responsible repository.
     *
     * @param feature Feature instance
     * @since 1.0.0
     */
    void register(Feature feature);

    /**
     * Finds a feature in the responsible repository by the features class.
     *
     * @param feature Feature class
     * @param <T>     Feature type
     * @return Feature instance or null
     * @since 1.0.0
     */
    <T extends Feature> T find(Class<? extends Feature> feature);

    /**
     * Finds a feature in the responsible repository by the feature id.
     *
     * @param id  Feature id
     * @param <T> Feature type
     * @return Feature instance or null
     * @since 1.0.0
     */
    <T extends Feature> T find(String id);
}
