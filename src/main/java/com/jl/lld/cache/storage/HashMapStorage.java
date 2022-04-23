package com.jl.lld.cache.storage;

import com.jl.lld.cache.exception.DataNotFoundException;
import com.jl.lld.cache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardik Kakadiya
 */
public class HashMapStorage<Key, Value> implements Storage<Key, Value> {
    private Map<Key, Value> map;
    private int capacity;

    public HashMapStorage(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if (map.size() == capacity) {
            throw new StorageFullException();
        }

        map.put(key, value);
    }

    @Override
    public Value get(Key key) throws DataNotFoundException {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            throw new DataNotFoundException();
        }
    }

    @Override
    public Value remove(Key key) throws DataNotFoundException {
        if (map.containsKey(key)) {
            return map.remove(key);
        } else {
            throw new DataNotFoundException();
        }
    }
}
