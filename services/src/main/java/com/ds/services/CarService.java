package com.ds.services;


import com.ds.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> smartSearch(String criteria);

    Car save(Car car);
}
