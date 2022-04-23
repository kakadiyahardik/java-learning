package com.jl.lld.cache.storage;

import com.jl.lld.cache.exception.DataNotFoundException;
import com.jl.lld.cache.exception.StorageFullException;

/**
 * @author Hardik Kakadiya
 */
public interface Storage<Key, Value> {
    void put(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws DataNotFoundException;

    Value remove(Key key) throws DataNotFoundException;
}
