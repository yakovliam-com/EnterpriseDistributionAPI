package com.fadecloud.fadedistributionapi.api.redis;

import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;

/**
 * This class is a provider interface that provides a redis connection provider
 * (which then provides the connection object)
 *
 * @param <T> the type of connection object
 */
public abstract class RedisProvider<T extends RedisConnectionProvider<?>> {

    /**
     * Redis connection provider
     */
    private final T redisConnectionProvider;

    /**
     * Redis connection provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected RedisProvider(T redisConnectionProvider) {
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


    /**
     * Sends a packet
     *
     * @param packet packet
     */
    public abstract void sendPacket(RedisPacket<? extends RedisProvider<?>> packet);
}
