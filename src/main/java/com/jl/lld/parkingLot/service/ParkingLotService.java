package com.jl.lld.parkingLot.service;

import com.jl.lld.parkingLot.exceptions.ParkingLotException;
import com.jl.lld.parkingLot.model.Car;
import com.jl.lld.parkingLot.model.ParkingLot;
import com.jl.lld.parkingLot.model.Slot;
import com.jl.lld.parkingLot.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        parkingLot.leave(slotNumber);
        parkingStrategy.addSlot(new Slot(slotNumber));
    }

    public List<Slot> getOccupideSlots() {
        Map<Integer, Slot> slots = parkingLot.getSlots();
        List<Slot> filledSlots = new ArrayList<>();
        for (Map.Entry<Integer, Slot> entry : slots.entrySet()) {
            if (!entry.getValue().isSlotFree()) {
                filledSlots.add(entry.getValue());
            }
        }
        return filledSlots;
    }

    public List<String> getCarRegiNumberWithColor(String color) {
        Map<Integer, Slot> slots = parkingLot.getSlots();
        List<String> carRegiNum = new ArrayList<>();
        for (Map.Entry<Integer, Slot> entry : slots.entrySet()) {
            if (!entry.getValue().isSlotFree() && entry.getValue().getParkedCar().getColor().equalsIgnoreCase(color)) {
                carRegiNum.add(entry.getValue().getParkedCar().getCarNumber());
            }
        }
        return carRegiNum;
    }

    public List<Slot> getSlotsForColor(String color) {
        List<Slot> slots = getOccupideSlots();

        return slots.stream()
                .filter(slot -> slot.getParkedCar().getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    /**
     * get slots where car parked with given registration number
     *
     * @param registrationNumber car number
     * @return
     */
    public Optional<Slot> getSlotsForRegiNumber(String registrationNumber) {
        List<Slot> slots = getOccupideSlots();

        return slots.stream()
                .filter(slot -> slot.getParkedCar().getCarNumber().equalsIgnoreCase(registrationNumber))
                .findFirst();
    }
}
