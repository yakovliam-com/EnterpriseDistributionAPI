package com.yakovliam.enterprisedistributionapi.api.redis.packet;

import com.yakovliam.enterprisedistributionapi.api.redis.BasicRedisServicesProvider;
import org.redisson.api.listener.MessageListener;

import java.util.Map;

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
        System.out.println("DEBUG: RECEIVED A PACKET: " + packet + ", " + channel);
        // handle the packet by checking if it has to handle anything with handshakes
        if (packet instanceof BasicRedisResponsePacket) {
            // remove from the failure cache if the handshake was completed
            this.redisServicesProvider.handshakePacketFailureCache().failureHandlerCache()
                    .asMap()
                    .entrySet()
                    .removeIf(entry -> entry.getKey().pipeId().equals(((BasicRedisResponsePacket) packet).pipeId()));
            // try to execute a success response callback
            // logically this works, but it breaks some conventions
            // that's okay because in this context it technically doesn't break anything
            BasicRedisHandshakeSuccessHandler successHandler = this.redisServicesProvider.handshakePacketSuccessCache().successHandlerCache()
                    .asMap()
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getKey().pipeId().equals(((BasicRedisResponsePacket) packet).pipeId()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(null);
            // remove from cache (if exists) now
            this.redisServicesProvider.handshakePacketSuccessCache().successHandlerCache()
                    .asMap()
                    .entrySet()
                    .removeIf(entry -> entry.getKey().pipeId().equals(((BasicRedisResponsePacket) packet).pipeId()));

            if (successHandler != null) {
                // execute the handler
                successHandler.onSuccess((BasicRedisResponsePacket) packet);
            }
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
