package com.jl.lld.cabbooking.controller;

import com.jl.lld.cabbooking.manager.CabManager;
import com.jl.lld.cabbooking.manager.TripManager;
import com.jl.lld.cabbooking.model.Cab;
import com.jl.lld.cabbooking.model.Driver;
import com.jl.lld.cabbooking.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hardik Kakadiya
 */
@RestController
public class CabController {

    @Autowired
    private CabManager cabManager;

    @Autowired
    private TripManager tripManager;

    @RequestMapping(value = "/cab/register", method = RequestMethod.POST)
    public ResponseEntity registerCab(final String cabId, final String driverName) {
        cabManager.createCab(new Cab(cabId, new Driver("", driverName)));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/cab/update/location", method = RequestMethod.POST)
    public ResponseEntity updateLocation(final String cabId, final Double x, final Double y) {
        cabManager.updateLocation(new Location(x, y), cabId);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/cab/update/availability", method = RequestMethod.POST)
    public ResponseEntity updateAvailability(final String cabId, final Boolean isAvailable) {
        cabManager.updateCabAvailability(cabId, isAvailable);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/cab/end/trip", method = RequestMethod.POST)
    public ResponseEntity endTrip(final String cabId) {
        tripManager.endTrip(cabManager.getCab(cabId));
        return ResponseEntity.ok("");
    }

}
