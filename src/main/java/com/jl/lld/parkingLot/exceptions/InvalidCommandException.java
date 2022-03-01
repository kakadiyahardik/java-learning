package com.jl.lld.parkingLot.exceptions;

/**
 * @author Hardik Kakadiya
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {
    }

    public InvalidCommandException(String message) {
        super(message);
    }
}
