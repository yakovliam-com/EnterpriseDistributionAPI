package com.fadecloud.fadedistributionapi.api.redis.publisher;

import com.fadecloud.fadedistributionapi.api.redis.BasicRedisServicesProvider;
import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisHandshakePacket;
import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisPacket;
import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisHandshakeFailureHandler;
import com.fadecloud.fadedistributionapi.api.redis.packet.cache.failure.HandshakePacketFailureCacheKey;
import org.redisson.api.RTopic;

import java.time.Duration;

public final class BasicRedisPublisher {

    /**
     * Services provider
     */
    private final BasicRedisServicesProvider<?> redisServicesProvider;

    /**
     * Redis publisher
     *
     * @param redisServicesProvider redis services provider
     */
    public BasicRedisPublisher(BasicRedisServicesProvider<?> redisServicesProvider) {
        this.redisServicesProvider = redisServicesProvider;
    }

    /**
     * Publishes a redis packet to a topic
     *
     * @param topic       topic
     * @param redisPacket redis packet
     */
    public void publish(RTopic topic, BasicRedisPacket redisPacket) {
        // publish the packet via the connection provider
        topic.publish(redisPacket);
    }

    /**
     * Publishes a redis handshake packet to a topic
     *
     * @param topic                topic
     * @param redisHandshakePacket redis handshake packet
     */
    public void publish(RTopic topic, BasicRedisHandshakePacket redisHandshakePacket, Duration timeout, BasicRedisHandshakeFailureHandler failureHandler) {
        // publish the packet via the connection provider
        topic.publish(redisHandshakePacket);

        // add this pipe id to the handshake cache along with the failure handler
        this.redisServicesProvider.handshakePacketFailureCache().failureHandlerCache()
                .put(new HandshakePacketFailureCacheKey(redisHandshakePacket.pipeId(), timeout, redisHandshakePacket), failureHandler);
    }
}
