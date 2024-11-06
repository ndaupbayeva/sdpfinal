package org.example;

class Truck implements Car {
    private String model;
    private double price;

    public Truck(String model) {
        this.model = model;
        this.price = 150.0;
    }

    public void displayDetails() {
        System.out.println("This is a " + model + " Truck.");
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

