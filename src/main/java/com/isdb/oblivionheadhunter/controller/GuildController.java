package com.isdb.oblivionheadhunter.controller;

import com.isdb.oblivionheadhunter.model.GuildMember;
import com.isdb.oblivionheadhunter.model.Quest;
import com.isdb.oblivionheadhunter.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/main/guild")
public class GuildController {

    private final GuildService service;

    @Autowired
    public GuildController(GuildService service) {
        this.service = service;
    }

    @PostMapping
    List<GuildMember> showGuildMembers(@RequestBody String guildName) {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        if (service.getMemberByHeroNameAndGuildName(principalLogin, guildName) == null
                && service.checkLeader(principalLogin) == null) return null;
        return service.getGuildMembers(guildName);
    }

    @PostMapping("/quests")
    List<Quest> showGuildQuest(@RequestBody String guildName) {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!service.checkGuildMember(principalLogin, guildName)
                && service.checkLeader(principalLogin) == null) return null;
        return service.getGuildQuests(guildName);
    }


    @PostMapping("/check")
    ResponseEntity<?> checkMembership(@RequestBody String guildName) {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        if (service.checkGuildMember(principalLogin, guildName)
                || service.checkLeader(principalLogin) != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/enter")
    ResponseEntity<?> enterGuild(@RequestBody String guildName) {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        service.enterGuild(principalLogin, guildName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
