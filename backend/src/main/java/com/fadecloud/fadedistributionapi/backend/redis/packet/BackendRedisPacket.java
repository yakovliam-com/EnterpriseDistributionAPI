package com.fadecloud.fadedistributionapi.backend.redis.packet;

import com.fadecloud.fadedistributionapi.api.redis.packet.RedisPacket;
import com.fadecloud.fadedistributionapi.backend.redis.BackendRedisProvider;

public abstract class BackendRedisPacket extends RedisPacket<BackendRedisProvider> {
    protected BackendRedisPacket(BackendRedisProvider redisProvider) {
        super(redisProvider);
    }
}
