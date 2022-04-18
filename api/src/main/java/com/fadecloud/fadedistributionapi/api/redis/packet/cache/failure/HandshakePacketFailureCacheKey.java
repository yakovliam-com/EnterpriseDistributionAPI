package com.fadecloud.fadedistributionapi.api.redis.packet.cache.failure;

import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisHandshakePacket;

import java.time.Duration;
import java.util.UUID;

public final class HandshakePacketFailureCacheKey {

    /**
     * The associated pipe id
     */
    private final UUID pipeId;

    /**
     * The timeout duration
     */
    private final Duration timeout;

    /**
     * Packet
     */
    private final BasicRedisHandshakePacket packet;

    /**
     * Handshake packet failure cache key
     *
     * @param pipeId  pipe id
     * @param timeout timeout
     * @param packet  packet
     */
    public HandshakePacketFailureCacheKey(UUID pipeId, Duration timeout, BasicRedisHandshakePacket packet) {
        this.pipeId = pipeId;
        this.timeout = timeout;
        this.packet = packet;
    }

    /**
     * Pipe id
     *
     * @return pipe id
     */
    public UUID pipeId() {
        return pipeId;
    }

    /**
     * Timeout
     *
     * @return timeout
     */
    public Duration timeout() {
        return timeout;
    }

    /**
     * Packet
     *
     * @return packet
     */
    public BasicRedisHandshakePacket packet() {
        return packet;
    }
}
