package com.marino.alfredo.usermanagementservice.repository;

import com.marino.alfredo.usermanagementservice.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
