package com.fadecloud.fadedistributionapi.api.model.topic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class TopicChannelKey extends TopicKey {

    /**
     * Topic channel key
     *
     * @param key key
     */
    @JsonCreator
    private TopicChannelKey(String key) {
        super(key);
    }

    /**
     * Creates a new topic key
     *
     * @param key key
     * @return topic key
     */
    public static TopicChannelKey of(String key) {
        return new TopicChannelKey(key);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TopicChannelKey)) {
            return false;
        }

        return this.key().equals(((TopicChannelKey) obj).key());
    }
}
