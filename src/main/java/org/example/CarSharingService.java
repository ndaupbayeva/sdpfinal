package org.example;

import org.example.payment.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class CarSharingService {
    private static CarSharingService instance;
    private Map<String, Boolean> carAvailability;

    private CarSharingService() {
        carAvailability = new HashMap<>();
        carAvailability.put("Honda SUV", true);
        carAvailability.put("Hyundai SUV", true);
        carAvailability.put("Toyota Sedan", true);
        carAvailability.put("Honda Sedan", true);
        carAvailability.put("Hyundai Hatchback", true);
        carAvailability.put("BMW Convertible", true);
        carAvailability.put("Ford Truck", true);
    }

    public static CarSharingService getInstance() {
        if (instance == null) {
            instance = new CarSharingService();
        }
        return instance;
    }


    public void rentCar(User user, Car car, int rentalDuration) {
        // Check if the car model exists in the carAvailability map
        if (car == null || !carAvailability.containsKey(car.getModel())) {
            System.out.println("Sorry, the car model " + car.getModel() + " is not available.");
            return;
        }

        if (!carAvailability.get(car.getModel())) {
            System.out.println("Sorry, the car is not available for rent right now.");
            return;
        }

        // Strategy Pattern - Payment options
        PaymentStrategy paymentMethod = user.getPaymentStrategy();
        double price = car.getPrice();
        // Calculate price based on rental duration (discount for long-term rentals)
        price = calculateRentalPrice(price, rentalDuration);
        paymentMethod.pay(price);

        // Observer Pattern - Notify User about successful booking
        user.notifyBooking(car);

        // Mark car as unavailable
        carAvailability.put(car.getModel(), false);

        // Final success message after rental
        System.out.println("Success! Your rental for the " + car.getModel() + " has been confirmed for " + rentalDuration + " days.");
        System.out.println("You have successfully rented the " + car.getModel() + " for " + rentalDuration + " days.");
    }

    public void buyCar(User user, Car car, String category) {
        PaymentStrategy paymentMethod = user.getPaymentStrategy();
        double price = car.getPrice();

        if ("Pre-owned".equalsIgnoreCase(category)) {
            price *= 0.8;
        }

        paymentMethod.pay(price);

        user.notifyPurchase(car);

        System.out.println("Success! You have successfully purchased the " + car.getModel() + " (" + category + ").");
        System.out.println("You are now the proud owner of the " + car.getModel() + " (" + category + ").");
    }
    private double calculateRentalPrice(double basePrice, int rentalDuration) {
        double totalPrice = basePrice * rentalDuration;
        if (rentalDuration > 7) {
            totalPrice *= 0.9;
        }
        return totalPrice;
    }

    public boolean isCarAvailable(Car car) {
        return carAvailability.get(car.getModel());
    }
}