package com.leska.redis_demo.controller;

import com.leska.redis_demo.model.User;
import com.leska.redis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<User> getById(@RequestParam("id") Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }
}
