package com.jl.lld.parkingLot.utils;

/**
 * @author Hardik Kakadiya
 */
public class IntegerValidator {

    /**
     * validate weather a string value is integer or not
     *
     * @param value string value
     * @return return boolean indicating that the value is integer or not
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
