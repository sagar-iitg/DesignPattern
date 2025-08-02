package com.sk.payment;

public class CashPayment implements IPaymentStrategy {
    public CashPayment(double fee) {
    }

    @Override
    public void processPayment(double amount) {
            System.out.println("Processing cash payment of $" + amount);
            // Logic for cash payment processing
    }
}
