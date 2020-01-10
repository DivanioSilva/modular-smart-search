package com.ds.repositories.querydsl;

import com.ds.entities.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonQueryDSLRepository extends BaseQueryDSLRepository<Person, Long> {
}
