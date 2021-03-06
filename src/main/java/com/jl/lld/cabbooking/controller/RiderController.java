package com.jl.lld.cabbooking.controller;

import com.jl.lld.cabbooking.manager.CabManager;
import com.jl.lld.cabbooking.manager.RiderManager;
import com.jl.lld.cabbooking.manager.TripManager;
import com.jl.lld.cabbooking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Hardik Kakadiya
 */
public class RiderController {

    @Autowired
    private CabManager cabManager;

    @Autowired
    private TripManager tripManager;

    @Autowired
    private RiderManager riderManager;

    @RequestMapping(value = "/rider/register", method = RequestMethod.POST)
    public ResponseEntity registerRider(final String riderId, final String riderName) {
        riderManager.createRider(new Rider(riderId, riderName));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity bookCab(final String riderId, Double fromX, Double fromY, Double toX, Double toY) {

        tripManager.createTrip(riderManager.getRider(riderId), new Location(fromX, fromY), new Location(toX, toY));

        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/rider/history", method = RequestMethod.POST)
    public ResponseEntity<List<Trip>> getHistory(final String riderId) {

        List<Trip> trips = tripManager.getHistory(riderId);

        return ResponseEntity.ok(trips);
    }
}
