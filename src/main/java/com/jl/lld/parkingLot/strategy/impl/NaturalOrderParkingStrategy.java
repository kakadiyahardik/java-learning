package com.jl.lld.parkingLot.strategy.impl;

import com.jl.lld.parkingLot.exceptions.NoFreeSlotAvailableException;
import com.jl.lld.parkingLot.model.Slot;
import com.jl.lld.parkingLot.strategy.ParkingStrategy;

import java.util.TreeSet;

/**
 * @author Hardik Kakadiya
 */
public class NaturalOrderParkingStrategy implements ParkingStrategy {

    private final TreeSet<Integer> slotsTree;

    public NaturalOrderParkingStrategy() {
        this.slotsTree = new TreeSet<>();
    }

    /**
     * {@inheritDoc}
     */
    public void addSlot(Slot slot) {
        this.slotsTree.add(slot.getNumber());
    }

    /**
     * {@inheritDoc}
     */
    public Integer getNextSlot() {
        if (slotsTree.isEmpty()) {
            throw new NoFreeSlotAvailableException("Free slot not available");
        }
        return this.slotsTree.first();
    }

    /**
     * {@inheritDoc}
     */
    public void removeSlot(Slot slot) {
        this.slotsTree.remove(slot.getNumber());
    }
}
