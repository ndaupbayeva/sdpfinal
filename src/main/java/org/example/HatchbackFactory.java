package org.example;

public class HatchbackFactory extends CarFactory {
    public Car createCar(String model) {
        return new Hatchback(model);
    }
}
