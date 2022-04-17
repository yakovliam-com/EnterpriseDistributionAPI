package com.fadecloud.fadedistributionapi.api.model.topic;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TopicKey {

    /**
     * The concatenation delimiter
     */
    private static final String DELIMITER = ":";

    /**
     * The topic key
     */
    private final String key;

    /**
     * Topic key
     *
     * @param key key
     */
    @JsonCreator
    protected TopicKey(String key) {
        this.key = key;
    }

    /**
     * Creates a new topic key
     *
     * @param key key
     * @return topic key
     */
    public static TopicKey of(String key) {
        return new TopicKey(key);
    }

    /**
     * Concatenates multiple topic keys into one with a separator
     *
     * @param arr array
     * @return topic key
     */
    public static TopicKey concat(TopicKey... arr) {
        return TopicKey.of(Arrays.stream(arr)
                .map(TopicKey::key)
                .collect(Collectors.joining(DELIMITER)));
    }

    /**
     * Key
     *
     * @return key
     */
    public String key() {
        return key;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TopicKey)) {
            return false;
        }

        return this.key.equals(((TopicKey) obj).key);
    }
}
