package com.jl.lld.parkingLot.strategy;

import com.jl.lld.parkingLot.model.Slot;

/**
 * @author Hardik Kakadiya
 */
public interface ParkingStrategy {
    /**
     * adding slot to parking strategy and its became available to park car
     *
     * @param slot slot details
     */
    void addSlot(Slot slot);

    /**
     * get next available slot to park vehicle
     *
     * @return slot details
     */
    Slot getNextSlot();

    /**
     * remove slot from available slots. so its marked occupied
     *
     * @param slot slot details
     */
    void removeSlot(Slot slot);
}
