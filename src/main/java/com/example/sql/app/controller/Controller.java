package com.example.sql.app.controller;

import com.example.sql.app.entity.Person;
import com.example.sql.app.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }
}
