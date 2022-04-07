package com.fadecloud.fadedistributionapi.api.redis.packet;

import com.fadecloud.fadedistributionapi.api.redis.RedisProvider;

/**
 * This class acts as a serializable blueprint to send data across redis pub/sub
 *
 * @param <T> the type of redis provider
 */
public abstract class RedisPacket<T extends RedisProvider<?>> {

    /**
     * Redis provider
     */
    private final T redisProvider;

    /**
     * Redis packet
     *
     * @param redisProvider redis provider
     */
    protected RedisPacket(T redisProvider) {
        this.redisProvider = redisProvider;
    }

    /**
     * Sends the packet over the network
     */
    public void send() {
        this.redisProvider.sendPacket(this);
    }
}
