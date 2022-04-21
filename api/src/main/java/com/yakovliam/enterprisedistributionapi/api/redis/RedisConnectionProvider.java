package com.yakovliam.enterprisedistributionapi.api.redis;

/**
 * This class acts as a connection provider to provide the redis connection object
 *
 * @param <T> the redis connection object
 */
public interface RedisConnectionProvider<T> {

    /**
     * Provides the connection object
     *
     * @return connection object
     */
    T provide();
}
