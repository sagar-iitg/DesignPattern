package com.sk.vehicle;

import com.sk.fare.ParkingFeeStrategy;

public class CarVehicle extends IVehicle {
    public CarVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
