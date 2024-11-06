package org.example;

class Convertible implements Car {
    private String model;
    private double price;

    public Convertible(String model) {
        this.model = model;
        this.price = 120.0;
    }

    public void displayDetails() {
        System.out.println("This is a " + model + " Convertible.");
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

