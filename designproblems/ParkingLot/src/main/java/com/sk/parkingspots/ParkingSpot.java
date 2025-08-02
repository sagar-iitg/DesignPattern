package com.sk.parkingspots;

import com.sk.vehicle.IVehicle;
import lombok.Getter;

@Getter
public abstract class ParkingSpot {
    private final int spotNumber;
    private boolean isOccupied;
    private IVehicle IVehicle;
    private final String spotType;
    // Constructor to initialize parking spot with spot number and type
    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.spotType = spotType;
    }
    // Method to check if the spot is occupied
    public boolean isOccupied() {
        return isOccupied;
    }
    // Abstract method to check if a vehicle can park in this spot
    public abstract boolean canParkVehicle(IVehicle IVehicle);
    // Method to park a vehicle in the spot
    public void parkVehicle(IVehicle IVehicle) {
        // Check if the spot is already occupied
        if (isOccupied) {
            throw new IllegalStateException("Spot is already occupied.");
        }
        // Check if the vehicle can be parked in this spot
        if (!canParkVehicle(IVehicle)) {
            throw new IllegalArgumentException(
                    "This spot is not suitable for" + IVehicle.getVehicleType());
        }
        this.IVehicle = IVehicle;
        this.isOccupied = true;
    }
    // Method to vacate the parking spot
    public void vacate() {
        // Check if the spot is already vacant
        if (!isOccupied) {
            throw new IllegalStateException("Spot is already vacant.");
        }
        this.IVehicle = null;
        this.isOccupied = false;
    }

}
