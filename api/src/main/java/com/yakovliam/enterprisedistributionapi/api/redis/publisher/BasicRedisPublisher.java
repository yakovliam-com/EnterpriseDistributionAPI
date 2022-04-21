package com.yakovliam.enterprisedistributionapi.api.redis.publisher;

import com.yakovliam.enterprisedistributionapi.api.redis.BasicRedisServicesProvider;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.BasicRedisHandshakeFailureHandler;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.BasicRedisHandshakePacket;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.BasicRedisHandshakeSuccessHandler;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.BasicRedisPacket;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.cache.failure.HandshakePacketFailureCacheKey;
import com.yakovliam.enterprisedistributionapi.api.redis.packet.cache.success.HandshakePacketSuccessCacheKey;
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
    public void publish(RTopic topic, BasicRedisHandshakePacket redisHandshakePacket, Duration timeout, BasicRedisHandshakeFailureHandler failureHandler, BasicRedisHandshakeSuccessHandler successHandler) {
        // publish the packet via the connection provider
        topic.publish(redisHandshakePacket);

        // add this pipe id to the handshake cache along with the failure handler
        this.redisServicesProvider.handshakePacketFailureCache().failureHandlerCache()
                .put(new HandshakePacketFailureCacheKey(redisHandshakePacket.pipeId(), timeout, redisHandshakePacket), failureHandler);
        this.redisServicesProvider.handshakePacketSuccessCache().successHandlerCache()
                .put(new HandshakePacketSuccessCacheKey(redisHandshakePacket.pipeId(), redisHandshakePacket), successHandler);
    }
}
