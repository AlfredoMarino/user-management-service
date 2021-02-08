package com.marino.alfredo.usermanagement.service;

import com.marino.alfredo.usermanagement.domain.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPerson(String personId);

    List<Person> getPersons();

    Person updatePerson(String personId, Person person);

    void deletePerson(String personId);
}
