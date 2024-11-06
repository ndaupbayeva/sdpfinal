package org.example.payment;

public class ExternalPaymentAdapter implements PaymentStrategy {
    private ExternalPaymentGateway externalPaymentGateway;

    public ExternalPaymentAdapter(ExternalPaymentGateway externalPaymentGateway) {
        this.externalPaymentGateway = externalPaymentGateway;
    }

    @Override
    public void pay(double amount) {
        externalPaymentGateway.processPayment(amount);
    }
}