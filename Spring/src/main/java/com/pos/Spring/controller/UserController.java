package com.pos.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.Spring.Service.UserService;
import com.pos.Spring.entity.User;
import com.pos.Spring.repository.UserRepository;

@RestController
public class UserController {
     @Autowired
    private UserService userService;

    // @Autowired
    // private UserRepository userRepository;
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // @GetMapping("/users/{userId}")
    // public User getUserById(@PathVariable Long userId){
    //     User user = userService.getUserById(userId);

    //     if(userId == null){
    //         return null;
    //     }else{
    //         return userRepository.body(user);
    //     }
    // }
}
