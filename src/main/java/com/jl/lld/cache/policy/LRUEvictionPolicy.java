package com.jl.lld.cache.policy;

import java.util.LinkedList;

/**
 * @author Hardik Kakadiya
 */
public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    LinkedList<Key> list;

    public LRUEvictionPolicy() {
        this.list = new LinkedList<>();
    }

    @Override
    public void keyAccessed(Key key) {
        list.remove(key);
        list.addLast(key);
    }

    @Override
    public Key evictKey() {
        System.out.println(list.size());
        System.out.println("E:" + list.getFirst());
        return list.poll();
    }
}
