package com.cabbooking.interfaces;

import com.cabbooking.constants.CabStatus;
import com.cabbooking.database.CabsManager;
import com.cabbooking.database.LocationManager;
import com.cabbooking.database.RidersManager;
import com.cabbooking.database.TripsManager;
import com.cabbooking.model.Cab;
import com.cabbooking.model.Location;
import com.cabbooking.model.Rider;
import com.cabbooking.model.Trip;
import com.cabbooking.strategies.CabMatchingStrategy;
import com.cabbooking.strategies.DefaultCabMatchingStrategy;

public class CabController {

    public static void main(String[] args) throws InterruptedException {

        LocationManager locationManager = new LocationManager();
        CabsManager cabsManager = new CabsManager();
        RidersManager ridersManager = new RidersManager();
        CabMatchingStrategy cabMatchingStrategy = new DefaultCabMatchingStrategy();

        TripsManager tripsManager = new TripsManager(cabsManager, ridersManager, cabMatchingStrategy, locationManager);

        locationManager.addNewLocation(new Location("1", "Bangalore"));
        locationManager.addNewLocation(new Location("2", "Ahemdabad"));
        locationManager.addNewLocation(new Location("3", "Delhi"));

        Cab cab1 = new Cab("1", "Saurabh", new Location("1", "Bangalore"));
        Cab cab2 = new Cab("2", "Raju", new Location("2", "Ahemdabad"));

        cabsManager.registerCab(cab1);
        cabsManager.registerCab(cab2);

        cabsManager.updateCabLocation(cab1.getId(), new Location("3", "Delhi"));

        cabsManager.updateCabStatus(cab1, CabStatus.IDLE);

        Rider rider1 = new Rider("1", "ankush");
        Thread.sleep(1000);

        Trip trip = tripsManager.createTrip(rider1, new Location("3", "Delhi"), new Location("2", "Ahemdabad"));
        Thread.sleep(5000);
        tripsManager.endTrip(trip);

        tripsManager.tripHistory("1").forEach((v) -> {
            System.out.println(v.toString());
        });

    }

}
