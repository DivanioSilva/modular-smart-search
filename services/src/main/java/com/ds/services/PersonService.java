package com.ds.services;

import com.ds.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface PersonService {

    Person save(Person person);

    List<Person> smartSearchByRsql(String criteria);

    List<Person> smartSearchByQueryDSL(Specification specification);

    Page<Person> smartSearchByQueryDSLPageble(Specification specification, Pageable page);

    List<Person> findByName(String name);

    List<Person> findAll();
}
