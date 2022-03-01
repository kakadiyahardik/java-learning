package com.jl.lld.parkingLot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
@ToString
public class Car {
    private String carNumber;
    private String color;

    public Car() {
    }

    public Car(String carNumber, String color) {
        this.carNumber = carNumber;
        this.color = color;
    }
}
