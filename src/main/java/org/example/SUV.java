package org.example;

public class SUV implements Car {
    private String model;
    private double price;

    public SUV(String model) {
        this.model = model;
        this.price = 100.0;
    }

    public void displayDetails() {
        System.out.println("This is a " + model + " SUV.");
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}