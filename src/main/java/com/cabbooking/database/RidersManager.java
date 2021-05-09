package com.cabbooking.database;

import com.cabbooking.Exceptions.RiderAlreadyExistsException;
import com.cabbooking.Exceptions.RiderNotFoundException;
import com.cabbooking.model.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {

    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NonNull final Rider newRider) {
        if (riders.containsKey(newRider.getId())) {
            throw new RiderAlreadyExistsException("Rider Already Exists!!!");
        }

        riders.put(newRider.getId(), newRider);
    }

    public Rider getRider(@NonNull final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException("Rider Not Found!!!");
        }

        return riders.get(riderId);
    }
}
