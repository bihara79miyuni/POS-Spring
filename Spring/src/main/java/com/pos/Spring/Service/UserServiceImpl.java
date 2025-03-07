package com.pos.Spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pos.Spring.entity.User;
import com.pos.Spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); //encode the password, so that it is not human readable

        return userRepository.save(user);
    }

    @Override 
    public User getUserByUsername(String  username){
        return userRepository.findByUsername(username).orElse(null);
    }
}
