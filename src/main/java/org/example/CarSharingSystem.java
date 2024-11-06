package org.example;
import org.example.payment.ExternalPaymentAdapter;
import org.example.payment.ExternalPaymentGateway;
import java.util.Scanner;

public class CarSharingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user1 = new User("Alice", new ExternalPaymentAdapter(new ExternalPaymentGateway()));

        CarSharingFacade facade = new CarSharingFacade();

        System.out.println("Welcome to the Car Sharing System!");
        System.out.println("Would you like to (1) Rent a Car or (2) Buy a Car?");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("You chose to rent a car.");
            System.out.println("Which type of car would you like to rent?");
            System.out.println("1. SUV\n2. Sedan\n3. Hatchback\n4. Convertible\n5. Truck");
            int carChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("How many days would you like to rent the car?");
            int rentalDuration = scanner.nextInt();

            String carType = carChoice == 1 ? "SUV" : carChoice == 2 ? "Sedan" : carChoice == 3 ? "Hatchback" : carChoice == 4 ? "Convertible" : "Truck";
            facade.rentCar(user1, carType, "Model", rentalDuration);

        } else if (choice == 2) {
            System.out.println("You chose to buy a car.");
            System.out.println("Which type of car would you like to buy?");
            System.out.println("1. SUV\n2. Sedan\n3. Hatchback\n4. Convertible\n5. Truck");
            int carChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Would you like to buy a (1) New or (2) Pre-owned car?");
            String category = scanner.nextLine();

            String carType = carChoice == 1 ? "SUV" : carChoice == 2 ? "Sedan" : carChoice == 3 ? "Hatchback" : carChoice == 4 ? "Convertible" : "Truck";
            facade.buyCar(user1, carType, "Model", category);

        } else {
            System.out.println("Invalid option. Please select either 1 or 2.");
        }

        scanner.close();
    }
}

