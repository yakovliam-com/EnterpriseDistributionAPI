package com.yakovliam.enterprisedistributionapi.api.redis.packet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.yakovliam.enterprisedistributionapi.api.topic.TopicChannelKey;
import com.yakovliam.enterprisedistributionapi.api.topic.TopicKey;

/**
 * This object represents a base-level packet that holds information to be sent over the network
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class BasicRedisPacket extends RedisPacket {

    /**
     * The key used to subscribe/publish to the packet event channel
     */
    private final BasicRedisPacketTopicType topicType;

    /**
     * Sender topic channel key
     */
    private final TopicChannelKey senderTopicChannelKey;

    /**
     * Redis packet
     *
     * @param topicType             topic type
     * @param senderTopicChannelKey sender topic channel key
     */
    protected BasicRedisPacket(BasicRedisPacketTopicType topicType, TopicChannelKey senderTopicChannelKey) {
        this.topicType = topicType;
        this.senderTopicChannelKey = senderTopicChannelKey;
    }

    /**
     * Returns the topic type
     *
     * @return topic type
     */
    public BasicRedisPacketTopicType topicType() {
        return this.topicType;
    }

    /**
     * Returns the topic key (from the topic type)
     *
     * @return topic key
     */
    public TopicKey topicKey() {
        return this.topicType.topicKey();
    }

    /**
     * Sender topic channel key
     *
     * @return channel key
     */
    public TopicChannelKey senderTopicChannelKey() {
        return senderTopicChannelKey;
    }
}
