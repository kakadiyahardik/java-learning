package com.jl.lld.parkingLot.exceptions;

/**
 * @author Hardik Kakadiya
 */
public class NoFreeSlotAvailableException extends RuntimeException{
    public NoFreeSlotAvailableException() {
        super();
    }

    public NoFreeSlotAvailableException(String message) {
        super(message);
    }
}
