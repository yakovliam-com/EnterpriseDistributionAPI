package com.yakovliam.enterprisedistributionapi.api.redis.packet;

import com.yakovliam.enterprisedistributionapi.api.topic.TopicKey;

public class BasicRedisPacketTopicType {
    /**
     * Topic key
     */
    private final TopicKey topicKey;

    /**
     * Packet topic type
     *
     * @param key key
     */
    public BasicRedisPacketTopicType(String key) {
        this.topicKey = TopicKey.of(key);
    }

    /**
     * Constructs a new basic redis packet topic type
     *
     * @param topicKey topic key
     * @return topic type
     */
    public static BasicRedisPacketTopicType of(String topicKey) {
        return new BasicRedisPacketTopicType(topicKey);
    }

    /**
     * Topic key
     *
     * @return topic key
     */
    public TopicKey topicKey() {
        return topicKey;
    }
}
