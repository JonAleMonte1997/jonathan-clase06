package com.jam.desafios.desafio06.service;

import com.jam.desafios.desafio06.entity.Person;
import com.jam.desafios.desafio06.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person createPerson(Person person) {

        return personRepository.save(person);
    }

    public List<Person> persons() {

        return personRepository.findAll();
    }

    public List<Person> createPersons(List<Person> persons) {

        /*
            Guardo las personas por cada iteración para ver la reacción del transactional
         */
        return persons.stream()
                .map(person -> {
                        try {
                            return personRepository.save(person);
                        } catch (Exception e) {
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El alias no puede ser nulo");
                        }
                }).collect(Collectors.toList());
    }
}
