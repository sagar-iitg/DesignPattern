package sagar;

public class Main {
    public static void main(String[] args) {

       // System.out.println("Hello world!");

        PaymentGatewayManager paymentGatewayManager=PaymentGatewayManager.getInstance();
        paymentGatewayManager.processPayment(100);


        // Attempt to create another instance (should return the existing instance)
        PaymentGatewayManager anotherPaymentGateway = PaymentGatewayManager.getInstance();
        // Check if both instances are the same.
        if (paymentGatewayManager == anotherPaymentGateway) {
            System.out.println("Both instances are the same. Singleton pattern is working.");
        } else {
            System.out.println("Singleton pattern is not working correctly.");
        }

    }
}