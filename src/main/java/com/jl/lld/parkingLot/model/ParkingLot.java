package com.jl.lld.parkingLot.model;

import lombok.Getter;

/**
 * @author Hardik Kakadiya
 */

public class ParkingLot {
    @Getter
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }
}
