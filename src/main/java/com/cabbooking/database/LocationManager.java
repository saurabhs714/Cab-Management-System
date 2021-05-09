package com.cabbooking.database;

import com.cabbooking.Exceptions.LocationAlreadyExistException;
import com.cabbooking.model.Location;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LocationManager {

    Map<String, Location> eligibleLocation = new HashMap<>();

    public void addNewLocation(@NonNull final Location location) {
        if (eligibleLocation.containsKey(location.getId())) {
            throw new LocationAlreadyExistException("Location Already Exist!!!");
        }

        eligibleLocation.put(location.getId(), location);
    }

    public boolean isLocationExist(@NonNull final Location location) {
        if (!eligibleLocation.containsKey(location.getId())) {
            return false;
        }
        return true;
    }
}
