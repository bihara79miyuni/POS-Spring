package com.pos.Spring.Service;

import org.springframework.stereotype.Service;

import com.pos.Spring.entity.User;

@Service
public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
}
