package org.example;

import java.util.HashMap;
import java.util.Map;

public class CarAvailability {
    private Map<String, Boolean> carAvailability = new HashMap<>();

    public CarAvailability() {
        carAvailability.put("Honda SUV", true);
        carAvailability.put("Toyota Sedan", true);
    }

    public boolean isCarAvailable(String carModel) {
        return carAvailability.getOrDefault(carModel, false);
    }

    public void markCarAsUnavailable(String carModel) {
        carAvailability.put(carModel, false);
    }
}
