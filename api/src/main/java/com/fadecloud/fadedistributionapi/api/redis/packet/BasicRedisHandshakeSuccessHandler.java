package com.fadecloud.fadedistributionapi.api.redis.packet;

@FunctionalInterface
public interface BasicRedisHandshakeSuccessHandler {

    /**
     * Handles a response packet being received
     *
     * @param packet packet
     */
    void onSuccess(BasicRedisResponsePacket packet);
}

