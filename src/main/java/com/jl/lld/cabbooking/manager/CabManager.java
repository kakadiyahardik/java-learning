package com.jl.lld.cabbooking.manager;

import com.jl.lld.cabbooking.exception.CabAlreadyExistException;
import com.jl.lld.cabbooking.exception.CabNotFoundException;
import com.jl.lld.cabbooking.exception.CanNotExistException;
import com.jl.lld.cabbooking.model.Cab;
import com.jl.lld.cabbooking.model.Location;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hardik Kakadiya
 */
@Component
public class CabManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void createCab(@NotNull Cab cab) {
        if (cabs.containsKey(cab.getId())) {
            throw new CabAlreadyExistException();
        }

        cabs.put(cab.getId(), cab);
    }

    public void updateLocation(@NotNull Location location, String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new CanNotExistException();
        }

        cabs.get(cabId).setCurrentLocation(location);
    }

    public void updateCabAvailability(String cabId, boolean isAvailable) {
        if (!cabs.containsKey(cabId)) {
            throw new CanNotExistException();
        }

        cabs.get(cabId).setAvailable(isAvailable);
    }

    public List<Cab> getClosestCabs(Location location, Double maxAllowedDistance) {
        List<Cab> result = new ArrayList<>();

        for (Cab cab : cabs.values()) {
            if (cab.isAvailable() && location.distance(cab.getCurrentLocation()) <= maxAllowedDistance) {
                result.add(cab);
            }
        }
        return result;
    }

    public Cab getCab(String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }

        return cabs.get(cabId);
    }
}
