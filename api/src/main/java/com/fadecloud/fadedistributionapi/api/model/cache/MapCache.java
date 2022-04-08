package com.fadecloud.fadedistributionapi.api.model.cache;

import java.util.Map;

public abstract class MapCache<K, V> {

    /**
     * Map
     */
    private Map<K, V> map;

    /**
     * Returns the map
     *
     * @return map
     */
    protected Map<K, V> map() {
        return this.map;
    }

    /**
     * Sets the current map
     *
     * @param map map
     */
    protected void map(Map<K, V> map) {
        this.map = map;
    }
}
