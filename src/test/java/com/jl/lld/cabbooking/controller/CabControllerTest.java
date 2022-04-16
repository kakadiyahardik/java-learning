package com.jl.lld.cabbooking.controller;

import com.jl.lld.cabbooking.manager.CabManager;
import com.jl.lld.cabbooking.manager.RiderManager;
import com.jl.lld.cabbooking.manager.TripManager;
import com.jl.lld.cabbooking.model.Cab;
import com.jl.lld.cabbooking.model.Driver;
import com.jl.lld.cabbooking.model.Location;
import com.jl.lld.cabbooking.model.Rider;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Hardik Kakadiya
 */
public class CabControllerTest {

    private CabManager cabManager;

    private TripManager tripManager;

    private RiderManager riderManager;

    @BeforeClass
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("bedore method");
        cabManager = new CabManager();
        tripManager = new TripManager();
        riderManager = new RiderManager();
    }

    @Test
    public void testCabBookingFlow() {

        String c1 = "c1";
        cabManager.createCab(new Cab(c1, new Driver("", "A")));

        String c2 = "c2";
        cabManager.createCab(new Cab(c2, new Driver("", "B")));

        String c3 = "c3";
        cabManager.createCab(new Cab(c3, new Driver("", "C")));

        String c4 = "c4";
        cabManager.createCab(new Cab(c4, new Driver("", "D")));

        cabManager.updateLocation(new Location(1.1, 2.1), c1);
        cabManager.updateLocation(new Location(1.4, 2.1), c2);
        cabManager.updateLocation(new Location(1.6, 2.1), c3);
        cabManager.updateLocation(new Location(1.8, 2.1), c4);

        cabManager.updateCabAvailability(c1, false);
        cabManager.updateCabAvailability(c4, false);

        String r1 = "r1";
        riderManager.createRider(new Rider(r1, "ra"));

        String r2 = "r2";
        riderManager.createRider(new Rider(r2, "rb"));

        String r3 = "r3";
        riderManager.createRider(new Rider(r3, "rc"));


        tripManager.createTrip(riderManager.getRider(r1), new Location(1.1, 2.1), new Location(10.1, 10.2));
        tripManager.createTrip(riderManager.getRider(r2), new Location(1.1, 2.1), new Location(10.1, 10.2));

        System.out.println("History");
        System.out.println(tripManager.getHistory(r1));
        System.out.println(tripManager.getHistory(r2));
    }
}