package com.cabbooking.database;

import com.cabbooking.Exceptions.CabAlreadyExistsException;
import com.cabbooking.Exceptions.CabNotFoundException;
import com.cabbooking.constants.CabStatus;
import com.cabbooking.model.Cab;
import com.cabbooking.model.Location;
import lombok.NonNull;

import java.util.*;

public class CabsManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void registerCab(@NonNull final Cab newCab) {
        if (cabs.containsKey(newCab.getId())) {
            throw new CabAlreadyExistsException("Cab Already exists!!!");
        }

        cabs.put(newCab.getId(), newCab);
        System.out.println("Registered Cab with Id :- " + newCab.getId());
    }

    public void updateCabStatus(@NonNull final Cab cab, @NonNull final CabStatus cabStatus) {
        if (!cabs.containsKey(cab.getId())) {
            throw new CabNotFoundException("Cab Not Found!!!");
        }

        Cab cabDetails = cabs.get(cab.getId());
        cabDetails.setStatus(cabStatus);
        cabDetails.setLastUpdatedStatusTime(new Date());
        System.out.println("Updated CabId "+ cab.getId() + " status to :- " + cabStatus);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException("Cab Not Found!!!");
        }

        cabs.get(cabId).setCurrLocation(newLocation);
        System.out.println("Updated CabId "+ cabId +" Location to :- " + newLocation.getCityName());
    }

    public void endCabTrip(@NonNull final Cab cab, @NonNull final Location toLocation) {
        if (!cabs.containsKey(cab.getId())) {
            throw new CabNotFoundException("Cab Not Found!!!");
        }

        cabs.get(cab.getId()).setCurrLocation(toLocation);
        cabs.get(cab.getId()).setStatus(CabStatus.IDLE);
        cabs.get(cab.getId()).setLastUpdatedStatusTime(new Date());
        System.out.println("Trip End for Cab Id :- "+ cab.getId());
    }

    public List<Cab> getCabs(@NonNull final Location fromLoc) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            if (cab.getCurrLocation().getCityName().equals(fromLoc.getCityName())) {
                result.add(cab);
            }
        }
        return result;
    }

}
