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

    public Slot(int number) {
        this.number = number;
    }
}
