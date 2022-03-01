package com.jl.lld.parkingLot.service;

import com.jl.lld.parkingLot.exceptions.ParkingLotException;
import com.jl.lld.parkingLot.model.Car;
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

    /**
     * park car to next available slot
     *
     * @param car car details
     * @return allotted slot
     */
    public int parkCar(Car car) {
        int nextAvailableSlot = parkingStrategy.getNextSlot();

        parkingLot.park(car, nextAvailableSlot);

        parkingStrategy.removeSlot(new Slot(nextAvailableSlot));

        return nextAvailableSlot;
    }

    /**
     * making slot free
     *
     * @param slotNumber slot number to make free
     */
    public void leave(int slotNumber) {
        Slot slot = parkingLot.leave(slotNumber);
        parkingStrategy.addSlot(new Slot(slotNumber));
    }
}
