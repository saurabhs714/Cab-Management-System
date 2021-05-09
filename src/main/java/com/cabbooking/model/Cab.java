package com.cabbooking.model;

import com.cabbooking.constants.CabStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class Cab {

    private String id;
    private String driverName;
    @Setter private Location currLocation;
    @Setter private CabStatus status;
    @Setter private Date lastUpdatedStatusTime;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.status = CabStatus.IDLE;
        this.lastUpdatedStatusTime = new Date();
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
