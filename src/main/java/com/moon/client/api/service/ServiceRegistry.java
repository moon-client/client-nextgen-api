package com.moon.client.api.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides access to all service types.
 * <p>
 * All services are identified by its base class, the implementation class should never be
 * used to register a service.
 * <p>
 * Why no actual dependency injection (JSR-330 standard)?
 * Minecraft itself is not built with dependency injection in mind.
 * It would require hacky or complex solutions to build upon dependency injection in a proper way.
 * Really not worth the effort. This is a good compromise, after all Guice is also just a
 * Map of classes and instances, just more advanced.
 *
 * @author lennoxlotl
 * @since 1.0.0
 */
public class ServiceRegistry {
    private static final Map<Class<? extends Service>, Service> SERVICES = new HashMap<>();

    /**
     * Registers a service into the registry.
     * <p>
     * A service cannot be registered twice, every service should only have one implementation at a time.
     *
     * @param service  The base service class
     * @param instance The instance / implementation
     * @since 1.0.0
     */
    public static void registerService(Class<? extends Service> service, Service instance) {
        if (SERVICES.containsKey(service)) {
            throw new IllegalArgumentException(String.format("Service %s is already registered", service));
        }

        SERVICES.put(service, instance);
    }

    /**
     * Finds a service in the registry.
     *
     * @param service The base service class
     * @param <T>     The service type
     * @return The service instance or null if not registered before
     * @since 1.0.0
     */
    public static <T extends Service> T findService(Class<? extends Service> service) {
        //noinspection unchecked
        return (T) SERVICES.get(service);
    }
}
