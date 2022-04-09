package com.fadecloud.fadedistributionapi.api.redis.publisher;

import com.fadecloud.fadedistributionapi.api.redis.RedisConnectionProvider;
import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;

public abstract class RedisPublisher<T extends RedisConnectionProvider<?>, P extends RedisPacket> {

    /**
     * Redis connection provider
     */
    private final T redisConnectionProvider;

    /**
     * Redis publisher
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected RedisPublisher(T redisConnectionProvider) {
        this.redisConnectionProvider = redisConnectionProvider;
    }

    /**
     * Returns the redis connection provider
     *
     * @return redis connection provider
     */
    protected T redisConnectionProvider() {
        return this.redisConnectionProvider;
    }

    /**
     * Publishes a redis packet over redis
     *
     * @param packet packet
     */
    public abstract void publish(P packet);
}
