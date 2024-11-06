package org.example;

public class CarRentalSystem {
    private static CarRentalSystem instance;

    private CarRentalSystem() {}

    public static synchronized CarRentalSystem getInstance() {
        if (instance == null) {
            instance = new CarRentalSystem();
        }
        return instance;
    }
}

