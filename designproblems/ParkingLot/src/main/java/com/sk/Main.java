package com.sk;

import com.sk.constants.DurationType;
import com.sk.fare.BasicHourlyRateStrategy;
import com.sk.fare.PremiumRateStrategy;
import com.sk.fare.ParkingFeeStrategy;
import com.sk.parkinglot.ParkingLot;
import com.sk.parkingspots.ConcreteParkingSpots.BikeParkingSpot;
import com.sk.parkingspots.ConcreteParkingSpots.CarParkingSpot;
import com.sk.parkingspots.ParkingSpot;
import com.sk.payment.CashPayment;
import com.sk.payment.CreditCardPayment;
import com.sk.payment.IPaymentStrategy;
import com.sk.vehicle.IVehicle;
import com.sk.vehicle.VehicleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize parking spots
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1, "Car"));
        parkingSpots.add(new CarParkingSpot(2,"Car"));
        parkingSpots.add(new BikeParkingSpot(3, "Bike"));
        parkingSpots.add(new BikeParkingSpot(4, "Bike"));
        // Initialize parking lot
        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        // Create fee strategies
        ParkingFeeStrategy basicHourlyRateStrategy = new BasicHourlyRateStrategy();
        ParkingFeeStrategy premiumRateStrategy = new PremiumRateStrategy();
        // Create vehicles using Factory Pattern with fee strategies
        IVehicle car1 = VehicleFactory.createVehicle("Car", "CAR123", basicHourlyRateStrategy);
        IVehicle car2 = VehicleFactory.createVehicle("Car", "CAR345", basicHourlyRateStrategy);

        IVehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE456", premiumRateStrategy);
        IVehicle bike2 = VehicleFactory.createVehicle("Bike", "BIKE123", premiumRateStrategy);


        // Park vehicles
        ParkingSpot carSpot = parkingLot.parkVehicle(car1);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike1);

        ParkingSpot carSpot2 = parkingLot.parkVehicle(car2);
        ParkingSpot bikeSpot2 = parkingLot.parkVehicle(bike2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();
        // Process payments using Strategy Patterns
        if (carSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double carFee = car1.calculateFee(2, DurationType.HOURS);
            IPaymentStrategy carIPaymentStrategy =
                    getPaymentStrategy(paymentMethod, carFee);
            carIPaymentStrategy.processPayment(carFee);
            parkingLot.vacateSpot(carSpot, car1);
        }
        if (bikeSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double bikeFee = bike1.calculateFee(3, DurationType.HOURS);
            IPaymentStrategy bikeIPaymentStrategy =
                    getPaymentStrategy(paymentMethod, bikeFee);
            bikeIPaymentStrategy.processPayment(bikeFee);
            parkingLot.vacateSpot(bikeSpot, bike1);
        }
        scanner.close();
    }
    private static IPaymentStrategy getPaymentStrategy(
            int paymentMethod, double fee) {
        switch (paymentMethod) {
            case 1:
                return new CreditCardPayment(fee);
            case 2:
                return new CashPayment(fee);
            default:
                System.out.println("Invalid choice! Default to Credit card payment.");
                return new CreditCardPayment(fee);
        }
    }
    }

    /*

Output :

Vehicle parked successfully in spot: 1
Vehicle parked successfully in spot: 3
Vehicle parked successfully in spot: 2
Vehicle parked successfully in spot: 4
Select payment method for your vehicle:
1. Credit Card
2. Cash
1
Processing credit card payment of $20.0
Car vacated the spot: 1
Processing credit card payment of $24.0
Bike vacated the spot: 3

Process finished with exit code 0

     */