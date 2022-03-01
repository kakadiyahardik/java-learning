package com.jl.lld.parkingLot.model;

import com.jl.lld.parkingLot.exceptions.InvalidSlotException;
import com.jl.lld.parkingLot.exceptions.ParkingLotException;
import com.jl.lld.parkingLot.exceptions.SlotIsNotFreeException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardik Kakadiya
 */

public class ParkingLot {
    @Getter
    private final int capacity;

    private static final int MAX_CAPACITY = 1000;
    @Getter
    private Map<Integer, Slot> slots;

    public ParkingLot(int capacity) {
        if (capacity <= 0 || capacity > MAX_CAPACITY) {
            throw new ParkingLotException("Invalid Capacity:" + capacity);
        }

        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    /**
     * Helper method to get {@link Slot}
     *
     * @param slotNumber slot number
     * @return {@link Slot} Object
     */
    private Slot getSlot(int slotNumber) {
        if (slotNumber > capacity || slotNumber <= 0) {
            throw new InvalidSlotException();
        }

        if (!slots.containsKey(slotNumber)) {
            slots.put(slotNumber, new Slot(slotNumber));
        }

        return slots.get(slotNumber);
    }

    /**
     * parked car if slot is free otherwise throw {@link SlotIsNotFreeException}
     *
     * @param car        car to park
     * @param slotNumber slot number on which you want to park car
     * @return slot details
     */
    public Slot park(Car car, int slotNumber) {
        Slot slot = getSlot(slotNumber);

        if (!slot.isSlotFree()) {
            throw new SlotIsNotFreeException();
        }

        slot.assignCar(car);
        return slot;
    }

    public Slot leave(int slotNumber) {
        Slot slot = getSlot(slotNumber);

        slot.leave();

        return slot;
    }
}
