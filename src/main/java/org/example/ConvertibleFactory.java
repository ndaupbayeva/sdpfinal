package org.example;

class ConvertibleFactory extends CarFactory {
    public Car createCar(String model) {
        return new Convertible(model);
    }
}