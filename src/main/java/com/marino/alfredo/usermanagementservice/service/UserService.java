package com.marino.alfredo.usermanagementservice.service;

import com.marino.alfredo.usermanagementservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(User user);

    List<User> getUsers();

    Optional<User> getUserByUsername(String username);
}
