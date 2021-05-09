package com.cabbooking.strategies;

import com.cabbooking.model.Cab;

import java.util.Date;
import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

    @Override
    public Cab matchCabToRider(List<Cab> candidateCabs) {

        if(candidateCabs.isEmpty()) {
            return null;
        }

        Date currTime = new Date();
        long maxIdleTime = 0L;
        Cab selectedCab = null;

        for(Cab cab : candidateCabs) {
        long diffInSec = (cab.getLastUpdatedStatusTime().getTime() - currTime.getTime())/ 1000 % 60;

        if(diffInSec > maxIdleTime) {
            maxIdleTime = diffInSec;
            selectedCab = cab;
        }

        }

        return selectedCab;
    }
}
