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
public class Location {
    private Double x;
    private Double y;

    public Location(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double distance(Location location) {
        return Math.sqrt(Math.pow(location.getX() - this.getX(), 2) + Math.pow(location.getY() - this.y, 2));
    }
}
