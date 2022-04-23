package com.jl.lld.cache.factory;

import com.jl.lld.cache.Cache;
import com.jl.lld.cache.policy.LRUEvictionPolicy;
import com.jl.lld.cache.storage.HashMapStorage;

/**
 * @author Hardik Kakadiya
 */
public class CacheFactory<Key, Value> {
    public static <Key, Value> Cache<Key, Value> getDefault(int capacity) {
        return new Cache<>(new HashMapStorage<>(capacity), new LRUEvictionPolicy<>());
    }
}
