package com.sk.parkingspots;

import com.sk.constants.VehicleType;
import com.sk.vehicle.IVehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(IVehicle IVehicle) {
        return VehicleType.CAR.name().equalsIgnoreCase(IVehicle.getVehicleType());
    }
}
