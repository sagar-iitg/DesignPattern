package com.sk.parkingspots.ConcreteParkingSpots;

import com.sk.parkingspots.ParkingSpot;
import com.sk.vehicle.IVehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(IVehicle IVehicle) {
        return "Car".equalsIgnoreCase(IVehicle.getVehicleType());
    }
}
