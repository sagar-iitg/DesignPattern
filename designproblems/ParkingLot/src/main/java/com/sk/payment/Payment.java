package com.sk.payment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class Payment {
    private double amount;
    private IPaymentStrategy IPaymentStrategy; // Payment strategy interface

    // Process the payment using the assigned strategy
    public void processPayment() {
        if (amount > 0) {
            IPaymentStrategy.processPayment(amount);  // Delegating to strategy
        } else {
            System.out.println("Invalid payment amount.");
            log.info("Invalid payment amount.");

        }
    }
}
