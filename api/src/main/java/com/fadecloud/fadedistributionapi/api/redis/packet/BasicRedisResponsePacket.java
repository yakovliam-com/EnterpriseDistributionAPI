package com.fadecloud.fadedistributionapi.api.redis.packet;

import com.fadecloud.fadedistributionapi.api.model.topic.TopicChannelKey;

import java.util.UUID;

/**
 * This object acts as a blueprint for a packet that is responding to another handshake packet
 */
public class BasicRedisResponsePacket extends BasicRedisPacket {

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
     * @param pipeId                pipe id
     */
    protected BasicRedisResponsePacket(BasicRedisPacketTopicType topicType, TopicChannelKey senderTopicChannelKey, UUID pipeId) {
        super(topicType, senderTopicChannelKey);
        // generate random id
        this.pipeId = pipeId;
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
