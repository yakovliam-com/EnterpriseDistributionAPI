package com.fadecloud.fadedistributionapi.api.redis.packet.cache;

import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisPacketFailureHandler;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.Scheduler;
import org.checkerframework.checker.index.qual.NonNegative;

public class HandshakePacketFailureCache {

    private final Cache<HandshakePacketFailureCacheKey, BasicRedisPacketFailureHandler> failureHandlerCache;

    /**
     * Handshake packet failure cache
     */
    public HandshakePacketFailureCache() {
        this.failureHandlerCache = Caffeine.newBuilder()
                .scheduler(Scheduler.systemScheduler())
                .weakKeys()
                .expireAfter(new Expiry<HandshakePacketFailureCacheKey, BasicRedisPacketFailureHandler>() {
                    @Override
                    public long expireAfterCreate(HandshakePacketFailureCacheKey key, BasicRedisPacketFailureHandler value, long currentTime) {
                        return key.timeout().toNanos();
                    }

                    @Override
                    public long expireAfterUpdate(HandshakePacketFailureCacheKey key, BasicRedisPacketFailureHandler value, long currentTime, @NonNegative long currentDuration) {
                        return Long.MAX_VALUE;
                    }

                    @Override
                    public long expireAfterRead(HandshakePacketFailureCacheKey key, BasicRedisPacketFailureHandler value, long currentTime, @NonNegative long currentDuration) {
                        return Long.MAX_VALUE;
                    }
                })
                .removalListener((key, value, cause) -> {
                    if (!cause.wasEvicted()) {
                        return;
                    }
                    if (key != null && value != null) {
                        // run the timeout handler
                        value.onTimeout(key.packet());
                    }
                })
                .build();
    }

    /**
     * Returns the failure handler cache
     *
     * @return cache
     */
    public Cache<HandshakePacketFailureCacheKey, BasicRedisPacketFailureHandler> failureHandlerCache() {
        return failureHandlerCache;
    }
}
