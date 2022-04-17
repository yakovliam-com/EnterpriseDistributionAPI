package com.fadecloud.fadedistributionapi.api.factory.config.mapper;

import com.fadecloud.fadedistributionapi.api.model.topic.TopicChannelKey;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.serialize.TypeSerializer;

import java.lang.reflect.Type;

/**
 * This class serializes and deserializes topic channel keys
 */
public class TopicChannelKeySerializer implements TypeSerializer<TopicChannelKey> {

    public static TopicChannelKeySerializer INSTANCE = new TopicChannelKeySerializer();

    @Override
    public TopicChannelKey deserialize(Type type, ConfigurationNode node) {
        return TopicChannelKey.of(node.getString());
    }

    @Override
    public void serialize(Type type, @Nullable TopicChannelKey obj, ConfigurationNode node) throws SerializationException {
        if (obj == null) {
            return;
        }

        node.set(obj.key());
    }
}
