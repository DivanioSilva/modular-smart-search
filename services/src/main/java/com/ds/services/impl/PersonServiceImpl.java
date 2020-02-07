package com.ds.services.impl;

import com.ds.entities.Person;
import com.ds.repositories.querydsl.PersonQueryDSLRepository;
import com.ds.repositories.rsql.PersonRSQLRepository;
import com.ds.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends AbstractServiceImpl implements PersonService {
    private final PersonRSQLRepository personRepository;
    private final PersonQueryDSLRepository personQueryDSLRepository;

    public PersonServiceImpl(PersonRSQLRepository personRepository,
                             PersonQueryDSLRepository personQueryDSLRepository) {
        super(personRepository);
        this.personRepository = personRepository;
        this.personQueryDSLRepository = personQueryDSLRepository;
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> smartSearchByQueryDSL(Specification specification) {
        return this.personRepository.findAll(specification);
    }

    @Override
    public Page<Person> smartSearchByQueryDSLPageble(Specification specification, Pageable page) {
        return this.personRepository.findAll(specification, page);
    }

    @Override
    public List<Person> findByName(String name) {
        return this.personRepository.findByName(name);
    }

    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }
}
