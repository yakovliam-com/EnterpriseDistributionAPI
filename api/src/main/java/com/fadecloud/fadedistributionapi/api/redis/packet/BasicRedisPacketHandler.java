package com.fadecloud.fadedistributionapi.api.redis.packet;

import com.fadecloud.fadedistributionapi.api.redis.BasicRedisServicesProvider;
import org.redisson.api.listener.MessageListener;

public abstract class BasicRedisPacketHandler<T extends BasicRedisPacket> implements MessageListener<T> {

    /**
     * Redis services provider
     */
    private final BasicRedisServicesProvider<?> redisServicesProvider;

    /**
     * Redis packet handler
     *
     * @param redisServicesProvider redis services provider
     */
    protected BasicRedisPacketHandler(BasicRedisServicesProvider<?> redisServicesProvider) {
        this.redisServicesProvider = redisServicesProvider;
    }

    @Override
    public void onMessage(CharSequence channel, T packet) {
        // handle the packet by checking if it has to handle anything with handshakes
        if (packet instanceof BasicRedisResponsePacket) {
            // remove from the failure cache if the handshake was completed
            this.redisServicesProvider.handshakePacketFailureCache().failureHandlerCache()
                    .asMap()
                    .entrySet()
                    .removeIf(entry -> entry.getKey().pipeId().equals(((BasicRedisResponsePacket) packet).pipeId()));
        }

        // call the normal handle method
        handle(packet);
    }

    /**
     * Handles a packet being received
     *
     * @param packet packet
     */
    public abstract void handle(T packet);
}
