package com.marino.alfredo.usermanagementservice.service;

import com.marino.alfredo.usermanagementservice.domain.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPerson(String personId);

    List<Person> getPersons();

    Person updatePerson(String personId, Person person);

    void deletePerson(String personId);
}
