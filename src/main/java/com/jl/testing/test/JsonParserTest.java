package com.jl.testing.test;

import javafx.util.Pair;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * @author Hardik Kakadiya
 */
public class JsonParserTest {
    public static void main(String[] args) {
       String a = "abc(121)";
        String b = "abc";

        Pair<String,String> p = new Pair<>();


        System.out.println(a.indexOf("("));
        System.out.println(b.indexOf("("));
        System.out.println(a.substring(a.indexOf("(")+1,a.indexOf(")")));

        
    }
}
