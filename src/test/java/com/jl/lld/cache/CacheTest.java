package com.jl.lld.cache;

import com.jl.lld.cache.factory.CacheFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Hardik Kakadiya
 */
public class CacheTest {

    @Test
    public void testCache() {
        Cache<Integer, Integer> cache = CacheFactory.getDefault(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);



        Assert.assertEquals((Integer) 3, cache.get(3));
        Assert.assertEquals((Integer) 1, cache.get(1));
//        assertNull(cache.get(2));
    }
}