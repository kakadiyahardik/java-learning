package com.jl.lld.cabbooking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
@NoArgsConstructor
public class Cab {
    private String id;
    private Driver driver;

    private Location currentLocation;
    private boolean available;
    private Trip currentTrip;

    public Cab(String id, Driver driver) {
        this.id = id;
        this.driver = driver;
    }
}
