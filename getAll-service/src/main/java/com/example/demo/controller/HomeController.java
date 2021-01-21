package com.example.demo.controller;


import com.example.demo.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/service2")
public class HomeController {

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String home(){
        return "Hello from getall-service " + env.getProperty("local.server.port");
    }


    @GetMapping("/getclazz/{id}")
    public Clazz getClazz(@PathVariable Integer id){
        Clazz clazz = new Clazz();
        clazz.setId(id);
        List<Object> users = restTemplate.getForObject("http://localhost:8200/service1/getAll",List.class);
        clazz.setUsers(users);

        return clazz;
    }

}
