package com.marino.alfredo.usermanagementservice.web.controller;

import com.marino.alfredo.usermanagementservice.domain.Person;
import com.marino.alfredo.usermanagementservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable String personId) {
        return new ResponseEntity<>(personService.getPerson(personId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable String personId, @RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(personId, person), HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable String personId) {
        personService.deletePerson(personId);
    }
}
