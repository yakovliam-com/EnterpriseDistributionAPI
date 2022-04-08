package com.fadecloud.fadedistributionapi.proxy.redis;

import com.fadecloud.fadedistributionapi.api.redis.RedisConnectionProvider;
import com.fadecloud.fadedistributionapi.api.redis.RedisProvider;
import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;

public abstract class ProxyRedisProvider<T extends RedisConnectionProvider<?>, P extends RedisPacket> extends RedisProvider<T, P> {

    /**
     * Proxy redis connection provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected ProxyRedisProvider(T redisConnectionProvider) {
        super(redisConnectionProvider);
    }
}
