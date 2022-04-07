package com.fadecloud.fadedistributionapi.backend.redis;

import com.fadecloud.fadedistributionapi.api.redis.RedisProvider;

public abstract class BackendRedisProvider extends RedisProvider<BackendRedisConnectionProvider<?>> {

    /**
     * Backend redis connection provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected BackendRedisProvider(BackendRedisConnectionProvider<?> redisConnectionProvider) {
        super(redisConnectionProvider);
    }
}
