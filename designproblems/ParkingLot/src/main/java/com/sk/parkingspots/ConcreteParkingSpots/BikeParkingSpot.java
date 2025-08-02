package com.sk.parkingspots.ConcreteParkingSpots;

import com.sk.parkingspots.ParkingSpot;
import com.sk.vehicle.IVehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(IVehicle IVehicle) {
        return "Bike".equalsIgnoreCase(IVehicle.getVehicleType());
    }
}
