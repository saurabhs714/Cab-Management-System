package com.cabbooking.strategies;

import com.cabbooking.model.Cab;

import java.util.List;

public interface CabMatchingStrategy {

    Cab matchCabToRider(List<Cab> candidateCabs);
}
