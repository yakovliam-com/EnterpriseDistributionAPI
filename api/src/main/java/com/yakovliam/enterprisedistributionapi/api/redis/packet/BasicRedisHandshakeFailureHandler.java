package com.yakovliam.enterprisedistributionapi.api.redis.packet;

@FunctionalInterface
public interface BasicRedisHandshakeFailureHandler {

    /**
     * Handles a packet being received
     *
     * @param packet packet
     */
    void onTimeout(BasicRedisHandshakePacket packet);
}
