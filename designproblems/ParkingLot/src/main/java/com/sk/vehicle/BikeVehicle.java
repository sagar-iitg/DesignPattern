package com.sk.vehicle;

import com.sk.fare.ParkingFeeStrategy;

public class BikeVehicle extends IVehicle {
    public BikeVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
