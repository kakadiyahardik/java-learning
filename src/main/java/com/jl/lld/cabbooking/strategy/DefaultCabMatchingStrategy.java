package com.jl.lld.cabbooking.strategy;

import com.jl.lld.cabbooking.model.Cab;
import com.jl.lld.cabbooking.model.Location;
import com.jl.lld.cabbooking.model.Rider;

import java.util.List;

/**
 * @author Hardik Kakadiya
 */
public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Cab matchCabForRider(Rider rider, List<Cab> availableCabs, Location from, Location to) {

        if (availableCabs.isEmpty()) {
            return null;
        }

        return availableCabs.get(0);
    }
}
