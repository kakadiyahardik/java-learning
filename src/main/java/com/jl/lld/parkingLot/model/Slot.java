package com.jl.lld.parkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
public class Slot {
    private int number;
    private Car parkedCar;

    public Slot(int number) {
        this.number = number;
    }

    public void assignCar(Car car) {
        this.parkedCar = car;
    }

    public boolean isSlotFree() {
        return parkedCar == null;
    }

    public void leave() {
        this.parkedCar = null;
    }
}
