package org.example;

class Hatchback implements Car {
    private String model;
    private double price;

    public Hatchback(String model) {
        this.model = model;
        this.price = 60.0; // Base price for Hatchback
    }

    public void displayDetails() {
        System.out.println("This is a " + model + " Hatchback.");
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}