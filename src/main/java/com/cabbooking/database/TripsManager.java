package com.cabbooking.database;

import com.cabbooking.Exceptions.CabNotFoundException;
import com.cabbooking.Exceptions.NoCabsAvailableException;
import com.cabbooking.constants.CabStatus;
import com.cabbooking.model.Cab;
import com.cabbooking.model.Location;
import com.cabbooking.model.Rider;
import com.cabbooking.model.Trip;
import com.cabbooking.strategies.CabMatchingStrategy;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class TripsManager {

    //Trips per Cab
    private Map<String, List<Trip>> trips = new HashMap<>();

    private CabsManager cabsManager;
    private RidersManager ridersManager;
    private CabMatchingStrategy cabMatchingStrategy;

    public TripsManager(
            CabsManager cabsManager,
            RidersManager ridersManager,
            CabMatchingStrategy cabMatchingStrategy) {
        this.cabsManager = cabsManager;
        this.ridersManager = ridersManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
    }

    public void createTrip(
            @NonNull final Rider rider,
            @NonNull final Location fromLoc,
            @NonNull final Location toLoc) {
        final List<Cab> closeByCabs =
                cabsManager.getCabs(fromLoc);
        final List<Cab> availableCabs = closeByCabs.stream()
                        .filter(cab -> cab.getStatus().equals(CabStatus.ON_TRIP))
                        .collect(Collectors.toList());

        final Cab selectedCab =
                cabMatchingStrategy.matchCabToRider(availableCabs);
        if (selectedCab == null) {
            throw new NoCabsAvailableException("No Cabs Available!!!");
        }

        final Trip newTrip = new Trip(rider, selectedCab, fromLoc, toLoc);
        if (!trips.containsKey(selectedCab.getId())) {
            trips.put(selectedCab.getId(), new ArrayList<>());
        }
        trips.get(selectedCab.getId()).add(newTrip);
        selectedCab.setStatus(CabStatus.ON_TRIP);
    }

    public List<Trip> tripHistory(@NonNull final String cabId) {
        if(!trips.containsKey(cabId)) {
            throw new CabNotFoundException("No Cab Found!!!");
        }
        return trips.get(cabId);
    }

    public void endTrip(@NonNull final Trip trip) {
        Cab cab = trip.getCab();
        cabsManager.endCabTrip(cab, trip.getToLocation());
    }
}
