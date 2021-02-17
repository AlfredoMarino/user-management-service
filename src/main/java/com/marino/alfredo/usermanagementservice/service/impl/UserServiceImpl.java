package com.marino.alfredo.usermanagementservice.service.impl;

import com.marino.alfredo.usermanagementservice.domain.User;
import com.marino.alfredo.usermanagementservice.exception.UniqueException;
import com.marino.alfredo.usermanagementservice.repository.UserRepository;
import com.marino.alfredo.usermanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) {

        if (getUserByUsername(user.getUsername()).isPresent()) {
            throw new UniqueException("User already exists");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRoles(user.getRoles());
        userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
