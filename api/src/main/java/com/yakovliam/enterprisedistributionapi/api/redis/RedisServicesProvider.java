package com.yakovliam.enterprisedistributionapi.api.redis;

import com.yakovliam.enterprisedistributionapi.api.redis.packet.RedisPacket;

/**
 * This class is a provider interface that provides a redis connection provider and exposes a publisher / subscriber
 *
 * @param <T> the type of connection object
 * @param <P> the type of redis packet
 */
public abstract class RedisServicesProvider<T extends RedisConnectionProvider<?>, P extends RedisPacket> {

    /**
     * Redis connection provider
     */
    private final T redisConnectionProvider;

    /**
     * Redis connection provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected RedisServicesProvider(T redisConnectionProvider) {
        this.redisConnectionProvider = redisConnectionProvider;
    }

    /**
     * Provides the connection provider
     *
     * @return connection provider
     */
    protected T provideConnectionProvider() {
        return this.redisConnectionProvider;
    }
}
