package com.ds.controller;

import com.ds.entities.Person;
import com.ds.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "person/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, path = "byQueryDSL/{query}")
    public List<Person> findPersonByQueryDSL(@PathVariable("query") String query){
        return this.personService.smartSearchByRsql(query);
    }
}
