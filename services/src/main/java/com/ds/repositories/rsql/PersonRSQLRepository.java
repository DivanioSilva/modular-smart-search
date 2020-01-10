package com.ds.repositories.rsql;

import com.ds.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRSQLRepository extends BaseRSQLRepository<Person> {
    List<Person> findByName(String name);
}
