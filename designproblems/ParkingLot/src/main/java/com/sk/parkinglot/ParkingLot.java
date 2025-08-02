package com.sk.parkinglot;

import com.sk.parkingspots.ParkingSpot;
import com.sk.vehicle.IVehicle;
import lombok.Getter;

import java.util.List;

@Getter
public class ParkingLot {
    // Getter for parking spots
    private final List<ParkingSpot> parkingSpots;
    // Constructor to initialize the parking lot with parking spots
    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
    // Method to find an available spot based on vehicle type
    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSpotType().equals(vehicleType)) {
                return spot; // Found an available spot for the vehicle type
            }
        }
        return null; // No available spot found for the given vehicle type
    }
    // Method to park a vehicle
    public ParkingSpot parkVehicle(IVehicle IVehicle) {
        ParkingSpot spot = findAvailableSpot(IVehicle.getVehicleType());
        if (spot != null) {
            spot.parkVehicle(IVehicle); // Mark the spot as occupied
            System.out.println(
                    "Vehicle parked successfully in spot: " + spot.getSpotNumber());
            return spot;
        }
        System.out.println(
                "No parking spots available for " + IVehicle.getVehicleType() + "!");
        return null;
    }
    // Method to vacate a parking spot
    public void vacateSpot(ParkingSpot spot, IVehicle IVehicle) {
        if (spot != null && spot.isOccupied()
                && spot.getIVehicle().equals(IVehicle)) {
            spot.vacate(); // Free the spot
            System.out.println(IVehicle.getVehicleType()
                    + " vacated the spot: " + spot.getSpotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant "
                    + "or the vehicle does not match.");
        }
    }
    // Method to find a spot by its number
    public ParkingSpot getSpotByNumber(int spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                return spot;
            }
        }
        return null; // Spot not found
    }
}
