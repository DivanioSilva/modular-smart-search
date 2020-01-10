package com.ds.repositories.querydsl;

import com.ds.entities.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarQueryDSLRepository extends BaseQueryDSLRepository<Car, Long> {
}
