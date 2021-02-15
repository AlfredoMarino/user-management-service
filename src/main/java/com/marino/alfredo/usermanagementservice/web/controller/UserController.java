package com.marino.alfredo.usermanagementservice.web.controller;

import com.marino.alfredo.usermanagementservice.domain.User;
import com.marino.alfredo.usermanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}
