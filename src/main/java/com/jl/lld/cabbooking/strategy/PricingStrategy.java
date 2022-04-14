package com.jl.lld.cabbooking.strategy;

import com.jl.lld.cabbooking.model.Location;

/**
 * @author Hardik Kakadiya
 */
public interface PricingStrategy {
    Double findPrice(Location from, Location to);
}
