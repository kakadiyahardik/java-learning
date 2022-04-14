package com.jl.lld.cabbooking.model;

import lombok.ToString;

/**
 * @author Hardik Kakadiya
 */
enum TripStatus {
    IN_PROGRESS,
    FINISHED
}

@ToString
public class Trip {
    private Cab cab;
    private Rider rider;
    private Location fromLocation;
    private Location toLocation;
    private Double price;
    private TripStatus status;

    public Trip(Cab cab, Rider rider, Location fromLocation, Location toLocation, Double price) {
        this.cab = cab;
        this.rider = rider;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.price = price;
        this.status = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.status = TripStatus.FINISHED;
    }
}
