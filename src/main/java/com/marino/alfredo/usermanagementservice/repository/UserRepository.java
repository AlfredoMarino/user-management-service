package com.marino.alfredo.usermanagementservice.repository;

import com.marino.alfredo.usermanagementservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
