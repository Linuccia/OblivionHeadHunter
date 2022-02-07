package com.isdb.oblivionheadhunter.controller;

import com.isdb.oblivionheadhunter.security.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

    @GetMapping("/login")
    String login() {
        Role role = (Role) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0];
        return role.getAuthority();
    }

}
