package com.marino.alfredo.usermanagement.service;

import com.marino.alfredo.usermanagement.domain.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getUsers();
}
