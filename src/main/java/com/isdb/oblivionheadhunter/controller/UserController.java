package com.isdb.oblivionheadhunter.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

    @GetMapping("/login")
    String login() {
        return "User logged in successfully";
    }

}
