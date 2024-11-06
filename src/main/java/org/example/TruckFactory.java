package org.example;

class TruckFactory extends CarFactory {
    public Car createCar(String model) {
        return new Truck(model);
    }
}

