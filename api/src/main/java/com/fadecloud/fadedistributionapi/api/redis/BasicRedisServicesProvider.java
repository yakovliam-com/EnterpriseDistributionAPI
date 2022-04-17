package com.fadecloud.fadedistributionapi.api.redis;

import com.fadecloud.fadedistributionapi.api.model.topic.TopicChannelKey;
import com.fadecloud.fadedistributionapi.api.model.topic.TopicKey;
import com.fadecloud.fadedistributionapi.api.redis.packet.BasicRedisPacket;
import com.fadecloud.fadedistributionapi.api.redis.packet.cache.HandshakePacketFailureCache;
import com.fadecloud.fadedistributionapi.api.redis.publisher.BasicRedisPublisher;
import org.redisson.api.RTopic;

public abstract class BasicRedisServicesProvider<T extends BasicRedisConnectionProvider> extends RedisServicesProvider<T, BasicRedisPacket> {

    /**
     * Redis publisher
     */
    private final BasicRedisPublisher redisPublisher;

    /**
     * Handshake packet failure
     */
    private final HandshakePacketFailureCache handshakePacketFailureCache;

    /**
     * Redis provider
     *
     * @param redisConnectionProvider redis connection provider
     */
    protected BasicRedisServicesProvider(T redisConnectionProvider) {
        super(redisConnectionProvider);
        // create handshake failure cache
        this.handshakePacketFailureCache = new HandshakePacketFailureCache();
        this.redisPublisher = new BasicRedisPublisher(this);
    }

    /**
     * Redis publisher
     *
     * @return publisher
     */
    public BasicRedisPublisher redisPublisher() {
        return this.redisPublisher;
    }

    /**
     * Redis connection provider
     *
     * @return connection provider
     */
    public T redisConnectionProvider() {
        return super.provideConnectionProvider();
    }

    /**
     * Handshake packet failure cache
     *
     * @return cache
     */
    public HandshakePacketFailureCache handshakePacketFailureCache() {
        return this.handshakePacketFailureCache;
    }

    /**
     * This method constructs an RTopic subscription/publishing channel that is specific to a server
     *
     * @param serverTopicChannelKey the channel key of the target server
     * @param topicKey              topic key
     * @return server topic
     */
    public abstract RTopic serverTopic(TopicChannelKey serverTopicChannelKey, TopicKey topicKey);

    /**
     * This method constructs an RTopic subscription/publishing channel that is specific to a custom channel name
     *
     * @param serverTopicChannelKey the channel key
     * @param topicKey              topic key
     * @return channel topic
     */
    public abstract RTopic customChannelTopic(TopicChannelKey serverTopicChannelKey, TopicKey topicKey);

    /**
     * This method constructs an RTopic subscription/publishing channel that listens/publishes to the global channel
     *
     * @param topicKey topic key
     * @return global topic
     */
    public abstract RTopic globalTopic(TopicKey topicKey);
}
