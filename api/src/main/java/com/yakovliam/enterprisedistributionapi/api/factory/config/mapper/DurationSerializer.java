package com.yakovliam.enterprisedistributionapi.api.factory.config.mapper;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.serialize.TypeSerializer;

import java.lang.reflect.Type;
import java.time.Duration;

public class DurationSerializer implements TypeSerializer<Duration> {

    public static DurationSerializer INSTANCE = new DurationSerializer();

    @Override
    public Duration deserialize(Type type, ConfigurationNode node) throws SerializationException {
        return Duration.ofMillis(node.getLong());
    }

    @Override
    public void serialize(Type type, @Nullable Duration obj, ConfigurationNode node) throws SerializationException {
        if (obj == null) {
            return;
        }

        node.set(obj.toMillis());
    }
}
