package com.jl.lld.test;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * @author Hardik Kakadiya
 */
public class JsonParserTest {
    public static void main(String[] args) {
        DateTime dt = new DateTime(1643692858686L);
        System.out.println(dt);
        System.out.println(dt.minusMinutes(2));
        System.out.println(Seconds.secondsBetween(new DateTime().toInstant(), dt.toInstant()).getSeconds());
    }
}
