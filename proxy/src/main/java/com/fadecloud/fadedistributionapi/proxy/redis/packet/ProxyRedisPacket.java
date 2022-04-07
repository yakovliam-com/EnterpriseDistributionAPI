package com.fadecloud.fadedistributionapi.proxy.redis.packet;

import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;
import com.fadecloud.fadedistributionapi.proxy.redis.ProxyRedisProvider;

public abstract class ProxyRedisPacket extends RedisPacket<ProxyRedisProvider> {
    protected ProxyRedisPacket(ProxyRedisProvider redisProvider) {
        super(redisProvider);
    }
}
