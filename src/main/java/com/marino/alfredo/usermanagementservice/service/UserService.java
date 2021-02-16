package com.marino.alfredo.usermanagementservice.service;

import com.marino.alfredo.usermanagementservice.domain.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getUsers();

    User getUserByUsername(String username);
}
