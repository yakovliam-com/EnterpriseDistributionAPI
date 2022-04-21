package com.yakovliam.enterprisedistributionapi.api.redis.packet.cache.success;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.BasicRedisHandshakeSuccessHandler;

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
