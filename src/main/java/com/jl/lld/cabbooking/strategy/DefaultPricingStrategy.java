package com.jl.lld.cabbooking.strategy;

import com.jl.lld.cabbooking.model.Location;

/**
 * @author Hardik Kakadiya
 */
public class DefaultPricingStrategy implements PricingStrategy {
    public static final Double PER_KM_RATE = 10.0;

    @Override
    public Double findPrice(Location from, Location to) {
        return from.distance(to) * PER_KM_RATE;
    }
}
