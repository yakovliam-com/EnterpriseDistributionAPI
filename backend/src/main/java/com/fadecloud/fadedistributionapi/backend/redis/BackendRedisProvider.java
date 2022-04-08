package com.fadecloud.fadedistributionapi.backend.redis;

import com.fadecloud.fadedistributionapi.api.redis.RedisConnectionProvider;
import com.fadecloud.fadedistributionapi.api.redis.RedisProvider;
import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;

public abstract class BackendRedisProvider<T extends RedisConnectionProvider<?>, P extends RedisPacket> extends RedisProvider<T, P> {

    /**
     * Backend redis connection provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected BackendRedisProvider(T redisConnectionProvider) {
        super(redisConnectionProvider);
    }
}
