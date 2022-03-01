package com.jl.lld.parkingLot.service;

import com.jl.lld.parkingLot.exceptions.ParkingLotException;
import com.jl.lld.parkingLot.model.ParkingLot;
import com.jl.lld.parkingLot.model.Slot;
import com.jl.lld.parkingLot.strategy.ParkingStrategy;

/**
 * @author Hardik Kakadiya
 */
public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    /**
     * create parking lot with given capacity
     *
     * @param parkingLot      parking lot to allocate
     * @param parkingStrategy strategy to use for park vehicles
     */
    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotException("Parking lot already exists.");
        }

        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(new Slot(i));
        }
    }
}
