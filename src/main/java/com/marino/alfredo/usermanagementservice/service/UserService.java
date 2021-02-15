package com.marino.alfredo.usermanagementservice.service;

import com.marino.alfredo.usermanagementservice.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void createUser(User user);

    List<User> getUsers();
}
