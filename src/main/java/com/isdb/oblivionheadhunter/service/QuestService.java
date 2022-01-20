package com.isdb.oblivionheadhunter.service;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.QuestCondition;
import com.isdb.oblivionheadhunter.model.QuestReward;
import com.isdb.oblivionheadhunter.repository.AttributesRepository;
import com.isdb.oblivionheadhunter.repository.ConditionsRepository;
import com.isdb.oblivionheadhunter.repository.QuestRepository;
import com.isdb.oblivionheadhunter.repository.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuestService {

    private final QuestRepository questRepository;
    private final AttributesRepository attrRepository;
    private final ConditionsRepository condRepository;
    private final RewardRepository rewardRepository;

    public Map<QuestCondition, Attributes> getConditions(String questName) {
        QuestCondition conditions = condRepository.findById(questRepository
                .findByName(questName).getConditions())
                .orElse(null);
        Attributes attributes = attrRepository.findById(conditions
                .getAttributes())
                .orElse(null);
        Map<QuestCondition, Attributes> map = new HashMap<>();
        map.put(conditions, attributes);
        return map;
    }

    public Map<QuestReward, Attributes> getReward(String questName) {
        QuestReward reward = rewardRepository.findById(questRepository
                        .findByName(questName).getReward())
                .orElse(null);
        Attributes attributes = attrRepository.findById(reward
                        .getAttributes())
                .orElse(null);
        Map<QuestReward, Attributes> map = new HashMap<>();
        map.put(reward, attributes);
        return map;
    }

    public boolean takeQuest(String questName, String heroName) {
        return questRepository.takeQuest(questName, heroName);
    }

}
