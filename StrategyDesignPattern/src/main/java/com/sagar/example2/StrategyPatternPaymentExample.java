package com.sagar.example2;

// Example Usage
public class StrategyPatternPaymentExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Using Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe", "123", "12/24");
        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100.00);

        // Using PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "securepassword");
        cart.setPaymentStrategy(payPalPayment);
        cart.checkout(250.00);


    }
}