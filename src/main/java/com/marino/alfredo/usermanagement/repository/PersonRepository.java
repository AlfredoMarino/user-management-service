package com.marino.alfredo.usermanagement.repository;

import com.marino.alfredo.usermanagement.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
