package com.jl.lld.cabbooking.manager;

import com.jl.lld.cabbooking.exception.RiderIsAlreadyExist;
import com.jl.lld.cabbooking.exception.RiderIsNotExistException;
import com.jl.lld.cabbooking.model.Rider;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardik Kakadiya
 */
@Component
public class RiderManager {
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NotNull Rider rider) {
        if (riders.containsKey(rider.getId())) {
            throw new RiderIsAlreadyExist();
        }

        riders.put(rider.getId(), rider);
    }

    public Rider getRider(String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderIsNotExistException();
        }

        return riders.get(riderId);
    }
}
