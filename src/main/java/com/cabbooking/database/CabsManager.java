package com.cabbooking.database;

import com.cabbooking.Exceptions.CabAlreadyExistsException;
import com.cabbooking.Exceptions.CabNotFoundException;
import com.cabbooking.constants.CabStatus;
import com.cabbooking.model.Cab;
import com.cabbooking.model.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {

    Map<String, Cab> cabs = new HashMap<>();
    List<Location> eligibleLoc = new ArrayList<>();

    public void registerCab(@NonNull final Cab newCab) {
        if (cabs.containsKey(newCab.getId())) {
            throw new CabAlreadyExistsException("Cab Already exists!!!");
        }

        cabs.put(newCab.getId(), newCab);
    }

    public void updateCabStatus(@NonNull final Cab cab, @NonNull final CabStatus cabStatus) {
        if (cabs.containsKey(cab.getId())) {
            throw new CabNotFoundException("Cab Not Found!!!");
        }

        cabs.get(cab.getId()).setStatus(cabStatus);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException("Cab Not Found!!!");
        }

        cabs.get(cabId).setCurrLocation(newLocation);
    }
}
