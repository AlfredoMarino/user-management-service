package com.marino.alfredo.usermanagementservice.service.impl;

import com.marino.alfredo.usermanagementservice.domain.Person;
import com.marino.alfredo.usermanagementservice.repository.PersonRepository;
import com.marino.alfredo.usermanagementservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(String personId) {
        return personRepository.findById(personId).get();
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(String personId, Person person) {
        Person personPersisted = getPerson(personId);
        personPersisted.setName(person.getName());
        personPersisted.setLastName(person.getLastName());
        personPersisted.setBirthdate(person.getBirthdate());
        personPersisted.setAboutMe(person.getAboutMe());
        personPersisted.setPhoto(person.getPhoto());

        return personRepository.save(personPersisted);
    }

    @Override
    public void deletePerson(String personId) {
        personRepository.deleteById(personId);
    }
}
