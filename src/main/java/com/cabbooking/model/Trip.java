package com.cabbooking.model;

import com.cabbooking.constants.TripStatus;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class Trip {

    private Rider rider;
    @Getter private Cab cab;
    private TripStatus status;
    private Location fromLocation;
    @Getter private Location toLocation;

    public Trip(
            @NonNull final Rider rider,
            @NonNull final Cab cab,
            @NonNull final Location fromLocation,
            @NonNull final Location toLocation) {
        this.rider = rider;
        this.cab = cab;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.status = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.status = TripStatus.FINISHED;
    }


}
