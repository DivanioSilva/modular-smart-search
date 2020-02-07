package com.ds.services.impl;

import com.ds.entities.Car;
import com.ds.repositories.rsql.CarRSQLRepository;
import com.ds.services.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends AbstractServiceImpl implements CarService {

    private final CarRSQLRepository repository;

    public CarServiceImpl(CarRSQLRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public List<Car> smartSearch(String criteria) {
        // TODO: 07/02/2020 to be implemented 
        return null;
    }

    @Override
    public Car save(Car car) {
        return this.repository.save(car);
    }
}
