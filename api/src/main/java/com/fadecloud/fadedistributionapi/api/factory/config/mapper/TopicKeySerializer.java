package com.fadecloud.fadedistributionapi.api.factory.config.mapper;

import com.fadecloud.fadedistributionapi.api.model.topic.TopicKey;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.serialize.TypeSerializer;

import java.lang.reflect.Type;

/**
 * This class serializes and deserializes topic keys
 */
public class TopicKeySerializer implements TypeSerializer<TopicKey> {

    public static TopicKeySerializer INSTANCE = new TopicKeySerializer();

    @Override
    public TopicKey deserialize(Type type, ConfigurationNode node) throws SerializationException {
        return TopicKey.of(node.getString());
    }

    @Override
    public void serialize(Type type, @Nullable TopicKey obj, ConfigurationNode node) throws SerializationException {
        if (obj == null) {
            return;
        }

        node.set(obj.key());
    }
}
