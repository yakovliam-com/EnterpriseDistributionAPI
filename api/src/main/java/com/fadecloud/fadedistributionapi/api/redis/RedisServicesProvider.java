package com.fadecloud.fadedistributionapi.api.redis;

import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;
import com.fadecloud.fadedistributionapi.api.redis.publisher.RedisPublisher;

/**
 * This class is a provider interface that provides a redis connection provider and exposes a publisher / subscriber
 *
 * @param <T> the type of connection object
 * @param <P> the type of redis packet
 */
public abstract class RedisServicesProvider<T extends RedisConnectionProvider<?>, P extends RedisPacket, P2 extends RedisPublisher<T, P>> {

    /**
     * Redis publisher
     */
    private final P2 redisPublisher;

    /**
     * Redis connection provider
     */
    private final T redisConnectionProvider;

    /**
     * Redis connection provider
     *
     * @param redisPublisher          redis publisher
     * @param redisConnectionProvider redis connection provider
     */
    protected RedisServicesProvider(P2 redisPublisher, T redisConnectionProvider) {
        this.redisPublisher = redisPublisher;
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
     * Returns the publisher
     *
     * @return publisher
     */
    public P2 publisher() {
        return this.redisPublisher;
    }
}
