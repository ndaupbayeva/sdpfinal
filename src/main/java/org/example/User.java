package org.example;

import org.example.payment.PaymentStrategy;

public class User {
    private String name;
    private PaymentStrategy paymentStrategy;

    public User(String name, PaymentStrategy paymentStrategy) {
        this.name = name;
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void notifyBooking(Car car) {
        System.out.println("Dear " + name + ", your " + car.getClass().getSimpleName() + " has been booked successfully!");
    }

    public void notifyPurchase(Car car) {
        System.out.println("Dear " + name + ", you have successfully purchased the " + car.getClass().getSimpleName() + "!");
    }


}
