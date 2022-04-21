package com.yakovliam.enterprisedistributionapi.api.factory.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;
import com.yakovliam.enterprisedistributionapi.api.factory.ObjectFactory;
import org.redisson.codec.JsonJacksonCodec;

public class JacksonCodecFactory implements ObjectFactory<JsonJacksonCodec> {

    @Override
    public JsonJacksonCodec construct() {

        ObjectMapper mapper = JsonMapper.builder()
                .visibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
                .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .visibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NON_PRIVATE)
                .addModule(new ParanamerModule())
                .build();

        return new JsonJacksonCodec(mapper);
    }
}
