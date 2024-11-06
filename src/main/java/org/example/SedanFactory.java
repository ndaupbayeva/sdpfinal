package org.example;

public class SedanFactory extends CarFactory {
    public Car createCar(String model) {
        return new Sedan(model);
    }
}

