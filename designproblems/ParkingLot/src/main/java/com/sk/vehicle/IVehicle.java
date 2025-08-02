package com.sk.vehicle;

import com.sk.constants.DurationType;
import com.sk.fare.ParkingFeeStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public abstract class IVehicle {

    private String licensePlate;
    private String vehicleType;
    private ParkingFeeStrategy feeStrategy;

    // Method to calculate parking fee based on duration and duration type
    public double calculateFee(int duration, DurationType durationType) {
        return feeStrategy.calculateFee(vehicleType, duration, durationType);
    }
}
