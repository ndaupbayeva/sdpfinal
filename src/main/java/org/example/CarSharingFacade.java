package org.example;

public class CarSharingFacade {
    private CarSharingService carSharingService;
    private CarFactory carFactory;

    public CarSharingFacade() {
        this.carSharingService = CarSharingService.getInstance();
    }

    public void rentCar(User user, String carType, String model, int rentalDuration) {
        Car car = carFactory.createCar(model);
        carSharingService.rentCar(user, car, rentalDuration);
    }

    public void buyCar(User user, String carType, String model, String category) {
        Car car = carFactory.createCar(model);
        carSharingService.buyCar(user, car, category);
    }
}
