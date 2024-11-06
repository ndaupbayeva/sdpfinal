package org.example;

public class Sedan implements Car {
    private String model;
    private double price;

    public Sedan(String model) {
        this.model = model;
        this.price = 50.0; // Base price for Sedan
    }

    public void displayDetails() {
        System.out.println("This is a " + model + " Sedan.");
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}


