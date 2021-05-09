package com.cabbooking.model;

import com.cabbooking.constants.CabStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {

    private String id;
    private String driverName;
    @Setter private Location currLocation;
    @Setter private CabStatus status;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.status = CabStatus.IDLE;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", driverName='" + driverName + '\'' +
                ", status=" + status +
                '}';
    }
}
