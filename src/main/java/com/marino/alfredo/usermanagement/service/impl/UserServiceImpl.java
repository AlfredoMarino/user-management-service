package com.marino.alfredo.usermanagement.service.impl;

import com.marino.alfredo.usermanagement.domain.User;
import com.marino.alfredo.usermanagement.repository.UserRepository;
import com.marino.alfredo.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
