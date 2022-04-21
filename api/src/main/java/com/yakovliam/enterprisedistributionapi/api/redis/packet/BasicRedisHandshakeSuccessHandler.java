package com.yakovliam.enterprisedistributionapi.api.redis.packet;

@FunctionalInterface
public interface BasicRedisHandshakeSuccessHandler {

    /**
     * Handles a response packet being received
     *
     * @param packet packet
     */
    void onSuccess(BasicRedisResponsePacket packet);
}

