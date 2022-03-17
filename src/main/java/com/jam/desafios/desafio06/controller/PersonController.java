package com.jam.desafios.desafio06.controller;

import com.jam.desafios.desafio06.entity.Person;
import com.jam.desafios.desafio06.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> persons() {

        return personService.persons();
    }

    @PostMapping("/persons/bunch")
    public List<Person> createPersons(@RequestBody List<Person> persons) {

        return personService.createPersons(persons);
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {

        return personService.createPerson(person);
    }
}
