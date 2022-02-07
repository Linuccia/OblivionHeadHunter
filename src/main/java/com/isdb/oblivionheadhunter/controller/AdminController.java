package com.isdb.oblivionheadhunter.controller;

import com.isdb.oblivionheadhunter.model.GuildMember;
import com.isdb.oblivionheadhunter.model.Quest;
import com.isdb.oblivionheadhunter.model.Request;
import com.isdb.oblivionheadhunter.model.pojo.NewQuest;
import com.isdb.oblivionheadhunter.model.pojo.RequestDecision;
import com.isdb.oblivionheadhunter.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/main/admin")
public class AdminController {

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/requests")
    List<Request> showRequests() {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        return service.getRequests(principalLogin);
    }

    @GetMapping("/quests")
    List<Quest> showQuests() {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        return service.getQuests(principalLogin);
    }

    // TODO
    @PostMapping("/members/rang")
    ResponseEntity<?> changeRang(@RequestBody GuildMember guildMember) {
        service.changeRang(guildMember.getId().getHeroName(),
                guildMember.getId().getGuildName(), guildMember.getRang());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/requests/enter")
    ResponseEntity<?> considerEnterGuild(@RequestBody RequestDecision requestDecision) {
        service.considerEnterGuild(requestDecision.getRequest().getId(),
                requestDecision.getDecision(), requestDecision.getRang());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/requests/end")
    ResponseEntity<?> considerEndQuest(@RequestBody RequestDecision requestDecision) {
        service.considerEndQuest(requestDecision.getRequest().getId(), requestDecision.getDecision());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/quests/new")
    ResponseEntity<?> addQuest(@RequestBody NewQuest quest) {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        if (service.addQuest(quest.getQuest().getName(), principalLogin, quest.getQuest().getDescription(),
                quest.getMinLevel(), quest.getCondition(), quest.getRewardDescription(), quest.getReward()))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
