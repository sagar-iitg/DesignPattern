package com.sagar.example2;

// Concrete Strategy for PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
        // Logic for pro// Context Class
        //class ShoppingCart {
        //    private PaymentStrategy paymentStrategy;
        //
        //    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        //        this.paymentStrategy = paymentStrategy;
        //    }
        //
        //    public void checkout(double amount) {
        //        paymentStrategy.pay(amount);
        //    }
        //}cessing PayPal payment
    }
}