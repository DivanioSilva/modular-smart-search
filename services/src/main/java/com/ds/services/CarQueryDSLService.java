package com.ds.services;

import com.ds.entities.Car;

public interface CarQueryDSLService {
    Iterable<Car> findCarSmartSearch(String brand,
                                     String fuelType,
                                     String plate,
                                     Integer numberOfDoors,
                                     Integer buildYear,
                                     Integer plateYear);
}
