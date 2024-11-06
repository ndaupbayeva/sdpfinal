package org.example.payment;

public class ExternalPaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via External Payment Gateway.");
    }
}