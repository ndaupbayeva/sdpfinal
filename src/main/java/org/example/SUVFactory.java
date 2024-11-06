package org.example;

public class SUVFactory extends CarFactory {
    public Car createCar(String model) {
        return new SUV(model);
    }
}

