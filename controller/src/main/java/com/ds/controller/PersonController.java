package com.ds.controller;

import com.ds.entities.Person;
import com.ds.repositories.rsql.PersonRSQLRepository;
import com.ds.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRSQLRepository personRSQLRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/byFindByRSQL/{query}")
    public List<Person> findPersonByQueryDSL(@PathVariable("query") String query){
        List<Person> personList = this.personService.smartSearchByRsql(query);
        return personList;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person savePerson(@RequestBody Person person){
        return this.personService.save(person);
    }
}
