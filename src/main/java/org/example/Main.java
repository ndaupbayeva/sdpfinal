package org.example;

import org.example.payment.CreditCardPayment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create user and set payment strategy (Strategy Pattern)
        User user1 = new User("Alice", new CreditCardPayment());

        // Present the initial choices (Rent or Buy)
        System.out.println("Welcome to the Car Sharing System!");
        System.out.println("Would you like to (1) Rent a Car or (2) Buy a Car?");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        if (choice == 1) {
            // User wants to rent a car
            System.out.println("You chose to rent a car.");
            System.out.println("Which type of car would you like to rent?");
            System.out.println("1. SUV\n2. Sedan\n3. Hatchback\n4. Convertible\n5. Truck");
            int carChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Get rental duration from the user
            System.out.println("How many days would you like to rent the car?");
            int rentalDuration = scanner.nextInt();

            // Rent a Car based on the choice
            Car car = null;
            String model = "";

            switch (carChoice) {
                case 1:
                    System.out.println("Enter the model of the SUV (Honda, Hyundai, etc.):");
                    model = scanner.nextLine();
                    car = new SUVFactory().createCar(model);
                    break;
                case 2:
                    System.out.println("Enter the model of the Sedan (Toyota, Honda, etc.):");
                    model = scanner.nextLine();
                    car = new SedanFactory().createCar(model);
                    break;
                case 3:
                    System.out.println("Enter the model of the Hatchback (Hyundai, Ford, etc.):");
                    model = scanner.nextLine();
                    car = new HatchbackFactory().createCar(model);
                    break;
                case 4:
                    System.out.println("Enter the model of the Convertible (BMW, Audi, etc.):");
                    model = scanner.nextLine();
                    car = new ConvertibleFactory().createCar(model);
                    break;
                case 5:
                    System.out.println("Enter the model of the Truck (Ford, Chevy, etc.):");
                    model = scanner.nextLine();
                    car = new TruckFactory().createCar(model);
                    break;
                default:
                    System.out.println("Invalid car choice.");
                    break;
            }

            if (car != null) {
                car.displayDetails();
                CarSharingService carSharingService = CarSharingService.getInstance();
                carSharingService.rentCar(user1, car, rentalDuration);
            }

        } else if (choice == 2) {
            // User wants to buy a car
            System.out.println("You chose to buy a car.");
            System.out.println("Which type of car would you like to buy?");
            System.out.println("1. SUV\n2. Sedan\n3. Hatchback\n4. Convertible\n5. Truck");
            int carChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Get buying category (New or Pre-owned)
            System.out.println("Would you like to buy a (1) New or (2) Pre-owned car?");
            String category = scanner.nextLine();

            // Buy a Car based on the choice
            Car car = null;
            String model = "";

            switch (carChoice) {
                case 1:
                    System.out.println("Enter the model of the SUV (Honda, Hyundai, etc.):");
                    model = scanner.nextLine();
                    car = new SUVFactory().createCar(model);
                    break;
                case 2:
                    System.out.println("Enter the model of the Sedan (Toyota, Honda, etc.):");
                    model = scanner.nextLine();
                    car = new SedanFactory().createCar(model);
                    break;
                case 3:
                    System.out.println("Enter the model of the Hatchback (Hyundai, Ford, etc.):");
                    model = scanner.nextLine();
                    car = new HatchbackFactory().createCar(model);
                    break;
                case 4:
                    System.out.println("Enter the model of the Convertible (BMW, Audi, etc.):");
                    model = scanner.nextLine();
                    car = new ConvertibleFactory().createCar(model);
                    break;
                case 5:
                    System.out.println("Enter the model of the Truck (Ford, Chevy, etc.):");
                    model = scanner.nextLine();
                    car = new TruckFactory().createCar(model);
                    break;
                default:
                    System.out.println("Invalid car choice.");
                    break;
            }

            if (car != null) {
                car.displayDetails();
                CarSharingService carSharingService = CarSharingService.getInstance();
                carSharingService.buyCar(user1, car, category);
            }

        } else {
            System.out.println("Invalid option. Please select either 1 or 2.");
        }

        scanner.close();
    }
    }