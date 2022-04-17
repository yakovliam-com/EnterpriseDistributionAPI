package com.fadecloud.fadedistributionapi.api.redis.packet.cache.success;

import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisHandshakeSuccessHandler;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class HandshakePacketSuccessCache {

    private final Cache<HandshakePacketSuccessCacheKey, BasicRedisHandshakeSuccessHandler> successHandlerCache;

    /**
     * Success packet cache
     */
    public HandshakePacketSuccessCache() {
        this.successHandlerCache = Caffeine.newBuilder()
                .weakKeys()
                .build();
    }

    /**
     * Returns the success handler cache
     *
     * @return cache
     */
    public Cache<HandshakePacketSuccessCacheKey, BasicRedisHandshakeSuccessHandler> successHandlerCache() {
        return successHandlerCache;
    }
}
