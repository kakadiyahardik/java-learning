package com.jl.lld.cabbooking.manager;

import com.jl.lld.cabbooking.exception.TripNotFoundExeption;
import com.jl.lld.cabbooking.model.*;
import com.jl.lld.cabbooking.strategy.CabMatchingStrategy;
import com.jl.lld.cabbooking.strategy.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Hardik Kakadiya
 */
@Component
public class TripManager {

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> trips = new HashMap<>();

    @Autowired
    private CabManager cabManager;

    @Autowired
    private CabMatchingStrategy cabMatchingStrategy;

    @Autowired
    private PricingStrategy pricingStrategy;

    public void createTrip(Rider rider, Location from, Location to) {

        List<Cab> nearestCabs = cabManager.getClosestCabs(from, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);

        List<Cab> availableCabs =
                nearestCabs.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());

        Cab selectedCab = cabMatchingStrategy.matchCabForRider(rider, availableCabs, from, to);

        if (selectedCab == null) {
            throw new CabsNotAvailableException();
        }

        Double price = pricingStrategy.findPrice(from, to);

        Trip trip = new Trip(selectedCab, rider, from, to, price);

        if (!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }

        trips.get(rider.getId()).add(trip);
        selectedCab.setCurrentTrip(trip);
    }

    public List<Trip> getHistory(String riderId) {
        return trips.get(riderId);
    }

    public void endTrip(Cab cab) {
        if (cab.getCurrentTrip() == null) {
            throw new TripNotFoundExeption();
        }

        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
