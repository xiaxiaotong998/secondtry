package com.example.demo;

import com.example.demo.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Indexcontroller {
    @GetMapping("")
    public String index() {
        user u= new user();
        String username1 = u.getUsername();
        System.out.println(username1);
        return "Hello Azure Service, " + username1;
    }
}
