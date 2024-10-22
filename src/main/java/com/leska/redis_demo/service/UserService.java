package com.leska.redis_demo.service;

import com.leska.redis_demo.model.User;
import com.leska.redis_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
