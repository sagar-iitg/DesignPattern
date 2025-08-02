package com.sk.vehicle;

import com.sk.constants.VehicleType;
import com.sk.fare.ParkingFeeStrategy;

public class VehicleFactory {
    public static IVehicle createVehicle(String vehicleType, String licensePlate, ParkingFeeStrategy feeStrategy) {
        if (vehicleType.equalsIgnoreCase(VehicleType.CAR.name())) {
            return new CarVehicle(licensePlate, vehicleType, feeStrategy);
        } else if (vehicleType.equalsIgnoreCase(VehicleType.BIKE.name())) {
            return new BikeVehicle(licensePlate, vehicleType, feeStrategy);
        }
        return new OtherVehicle(licensePlate, vehicleType, feeStrategy); // For unsupported vehicle types
    }
}
