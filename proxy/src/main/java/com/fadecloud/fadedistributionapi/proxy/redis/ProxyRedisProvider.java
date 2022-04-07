package com.fadecloud.fadedistributionapi.proxy.redis;

import com.fadecloud.fadedistributionapi.api.redis.RedisProvider;

public abstract class ProxyRedisProvider extends RedisProvider<ProxyRedisConnectionProvider<?>> {

    /**
     * Proxy redis connection provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected ProxyRedisProvider(ProxyRedisConnectionProvider<?> redisConnectionProvider) {
        super(redisConnectionProvider);
    }
}
