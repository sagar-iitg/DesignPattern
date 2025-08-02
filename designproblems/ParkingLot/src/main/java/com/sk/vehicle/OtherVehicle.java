package com.sk.vehicle;

import com.sk.fare.ParkingFeeStrategy;

public class OtherVehicle extends IVehicle {
    public OtherVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}
