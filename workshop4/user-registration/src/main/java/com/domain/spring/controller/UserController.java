package com.domain.spring.controller;

import com.domain.spring.model.User;
import com.domain.spring.exception.UserRegistrationException;
import com.domain.spring.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wszybisty
 */
@RestController
@RequestMapping("users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) throws UserRegistrationException {
        return userService.registerUser(user);
    }
}
