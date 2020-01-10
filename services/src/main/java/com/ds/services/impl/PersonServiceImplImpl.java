package com.ds.services.impl;

import com.ds.entities.Person;
import com.ds.repositories.rsql.PersonRSQLRepository;
import com.ds.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImplImpl extends AbstractServiceImpl implements PersonService {
    private final PersonRSQLRepository personRepository;

    public PersonServiceImplImpl(PersonRSQLRepository personRepository) {
        super(personRepository);
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
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
