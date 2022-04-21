package com.yakovliam.enterprisedistributionapi.api.factory;

public interface ObjectFactory<T> {

    /**
     * Constructs a T
     *
     * @return T
     */
    T construct();
}
