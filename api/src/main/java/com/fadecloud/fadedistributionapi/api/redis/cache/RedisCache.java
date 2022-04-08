package com.fadecloud.fadedistributionapi.api.redis.cache;

import com.fadecloud.fadedistributionapi.api.model.cache.MapCache;
import com.fadecloud.fadedistributionapi.api.redis.RedisProvider;

public abstract class RedisCache<K, V> extends MapCache<K, V> {

    /**
     * Redis provider
     */
    protected final RedisProvider<?> redisProvider;

    /**
     * Redis cache
     *
     * @param redisProvider redis provider
     */
    protected RedisCache(RedisProvider<?> redisProvider) {
        this.redisProvider = redisProvider;
    }

    /**
     * A blueprint method that updates the current cache from redis
     */
    public abstract void updateFromRedis();
}
