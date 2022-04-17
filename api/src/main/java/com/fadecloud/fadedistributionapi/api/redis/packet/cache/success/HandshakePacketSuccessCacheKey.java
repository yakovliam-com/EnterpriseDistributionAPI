package com.fadecloud.fadedistributionapi.api.redis.packet.cache.success;

import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisHandshakePacket;

import java.util.UUID;

public final class HandshakePacketSuccessCacheKey {

    /**
     * The associated pipe id
     */
    private final UUID pipeId;

    /**
     * Packet
     */
    private final BasicRedisHandshakePacket packet;

    /**
     * Handshake packet success cache key
     *
     * @param pipeId pipe id
     * @param packet packet
     */
    public HandshakePacketSuccessCacheKey(UUID pipeId, BasicRedisHandshakePacket packet) {
        this.pipeId = pipeId;
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
     * Packet
     *
     * @return packet
     */
    public BasicRedisHandshakePacket packet() {
        return packet;
    }
}
