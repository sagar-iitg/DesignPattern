package com.sk.parkingspots;

import com.sk.constants.VehicleType;
import com.sk.vehicle.IVehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(IVehicle IVehicle) {
        return VehicleType.BIKE.name().equalsIgnoreCase(IVehicle.getVehicleType());
    }
}
