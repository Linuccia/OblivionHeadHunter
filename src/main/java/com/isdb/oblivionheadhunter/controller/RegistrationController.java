package com.isdb.oblivionheadhunter.controller;

import com.isdb.oblivionheadhunter.model.*;
import com.isdb.oblivionheadhunter.model.pojo.RegistrationRequest;
import com.isdb.oblivionheadhunter.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/create")
public class RegistrationController {

    private final RegistrationService regService;

    @Autowired
    public RegistrationController(RegistrationService regService) {
        this.regService = regService;
    }

    @PostMapping
    ResponseEntity<?> addHero(@RequestBody RegistrationRequest request) {
        if (request.getHero().getName().equals("") || !regService.addHero(request.getHero())) {
            System.out.println("User " + request.getUser().getUsername() + " already exists");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            regService.saveUser(request.getUser());
            System.out.println("User " + request.getUser().getUsername() + " registered successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/races")
    List<Race> getRaces() {
        return regService.getRaces();
    }

    @GetMapping("/classes")
    List<HeroClass> getClasses() {
        return regService.getClasses();
    }

    @GetMapping("/galaxies")
    List<Galaxy> getGalaxies() {
        return regService.getGalaxies();
    }

}
