package com.yakovliam.enterprisedistributionapi.api.redis.packet;

import com.yakovliam.enterprisedistributionapi.api.topic.TopicChannelKey;

import java.util.UUID;

/**
 * This object acts as a blueprint for a packet that requires a response, hence the 'handshake' in the class name
 */
public class BasicRedisHandshakePacket extends BasicRedisPacket {

    /**
     * The id associated with this current pipe of communication
     * If a handshake packet does not fail, this pipe id will be used to remove it from the timeout/failure cache
     */
    private final UUID pipeId;

    /**
     * Redis packet
     *
     * @param topicType             topic type
     * @param senderTopicChannelKey sender topic channel key
     */
    protected BasicRedisHandshakePacket(BasicRedisPacketTopicType topicType, TopicChannelKey senderTopicChannelKey) {
        super(topicType, senderTopicChannelKey);
        // generate random id
        this.pipeId = UUID.randomUUID();
    }

    /**
     * Pipe Id
     *
     * @return pipe id
     */
    public UUID pipeId() {
        return pipeId;
    }
}
