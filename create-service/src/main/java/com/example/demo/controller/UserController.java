package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service1")
public class UserController {

    @Autowired
    Environment env;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        return "Hello from create-service " + env.getProperty("local.server.port");
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
