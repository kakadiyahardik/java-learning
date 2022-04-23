package com.jl.lld.cache;

import com.jl.lld.cabbooking.model.Cab;
import com.jl.lld.cache.exception.StorageFullException;
import com.jl.lld.cache.policy.EvictionPolicy;
import com.jl.lld.cache.storage.Storage;

/**
 * @author Hardik Kakadiya
 */
public class Cache<Key, Value> {
    Storage<Key, Value> storage;
    EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value) {
        try {
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println("storage full try to evict key");
            Key evictKey = evictionPolicy.evictKey();
            storage.remove(evictKey);
            System.out.println("Evicted key: " + evictKey);
            put(key, value);
        }
    }

    public Value get(Key key) {
        Value value = storage.get(key);
        evictionPolicy.keyAccessed(key);
        return value;
    }
}
