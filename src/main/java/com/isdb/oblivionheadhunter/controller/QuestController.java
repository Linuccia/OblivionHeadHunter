package com.isdb.oblivionheadhunter.controller;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.QuestCondition;
import com.isdb.oblivionheadhunter.model.QuestReward;
import com.isdb.oblivionheadhunter.model.pojo.QuestConditionsAndReward;
import com.isdb.oblivionheadhunter.service.QuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/main/guild/quests")
public class QuestController {

    private final QuestService service;

    public QuestController(QuestService service) {
        this.service = service;
    }

    @PostMapping("/info")
    QuestConditionsAndReward showInfo(@RequestBody String questName) {
        QuestConditionsAndReward info = new QuestConditionsAndReward();
        Map<QuestCondition, Attributes> condMap = service.getConditions(questName);
        QuestCondition cond = (QuestCondition) condMap.keySet().toArray()[0];
        info.setCondition(cond);
        info.setCondAttributes(condMap.get(cond));
        Map<QuestReward, Attributes> rewMap = service.getReward(questName);
        QuestReward rew = (QuestReward) rewMap.keySet().toArray()[0];
        info.setReward(rew);
        info.setRewAttributes(rewMap.get(rew));
        return info;
    }

    @PostMapping("/take")
    ResponseEntity<?> takeQuest(@RequestBody String questName) {
        String principalLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        if (service.takeQuest(questName, principalLogin)) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
