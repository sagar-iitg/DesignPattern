package com.sk.payment;

public class CreditCardPayment implements IPaymentStrategy {
    public CreditCardPayment(double fee) {
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
