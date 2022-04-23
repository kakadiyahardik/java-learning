package com.jl.lld.cache.policy;

/**
 * @author Hardik Kakadiya
 */
public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);

    Key evictKey();
}
