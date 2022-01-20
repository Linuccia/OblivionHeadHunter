package com.isdb.oblivionheadhunter.controller;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.Hero;
import com.isdb.oblivionheadhunter.model.pojo.HeroAndAttributes;
import com.isdb.oblivionheadhunter.model.Quest;
import com.isdb.oblivionheadhunter.model.pojo.QuestEnd;
import com.isdb.oblivionheadhunter.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/main/user")
public class HeroController {

    private final HeroService service;

    @Autowired
    public HeroController(HeroService service) {
        this.service = service;
    }

    @GetMapping
    HeroAndAttributes showHero() {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Hero hero = service.getHero(principalLogin);
        Attributes attributes = service.getHeroAttributes(hero.getAttributes());
        return new HeroAndAttributes(hero, attributes);
    }

    @GetMapping("/quests")
    List<Quest> showHeroQuests() {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        return service.getHeroQuests(principalLogin);
    }

    @PostMapping("/quests/end")
    ResponseEntity<?> endQuest(@RequestBody QuestEnd questEnd) {
        service.endQuest(questEnd.getQuestName(), questEnd.getResult(), questEnd.getDescription());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
