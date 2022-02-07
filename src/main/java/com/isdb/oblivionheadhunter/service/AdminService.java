package com.isdb.oblivionheadhunter.service;

import com.isdb.oblivionheadhunter.model.*;
import com.isdb.oblivionheadhunter.repository.GuildMemberRepository;
import com.isdb.oblivionheadhunter.repository.GuildRepository;
import com.isdb.oblivionheadhunter.repository.QuestRepository;
import com.isdb.oblivionheadhunter.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final RequestRepository requestRepository;
    private final GuildMemberRepository memberRepository;
    private final GuildRepository guildRepository;
    private final QuestRepository questRepository;

    public List<Request> getRequests(String adminName) {
        return requestRepository.findByGuildName(guildRepository.findByAdminName(adminName).getName());
    }

    public List<Quest> getQuests(String adminName) {
        String guildName = guildRepository.findByAdminName(adminName).getName();
        List<Quest> list = new ArrayList<>();
        list.addAll(questRepository.findByGuildNameAndStatus(guildName, null));
        list.addAll(questRepository.findByGuildNameAndStatus(guildName, "начат"));
        return list;
    }

    public void changeRang(String heroName, String guildName, String rang) {
        memberRepository.changeRang(heroName, guildName, rang);
    }

    public void considerEnterGuild(Integer requestId, String decision, String rang) {
        requestRepository.considerEnterGuild(requestId, decision, rang);
    }

    public void considerEndQuest(Integer requestId, String decision) {
        requestRepository.considerEndQuest(requestId, decision);
    }

    public boolean addQuest(String name, String adminName, String description,
                            Integer minLevel, Attributes condition, String rewDescription, Attributes reward) {
        if (questRepository.findByName(name) != null) return false;
        Integer condId = questRepository.setConditions(minLevel, condition.getPower(), condition.getIntellect(),
                condition.getWillpower(), condition.getDexterity(), condition.getSpeed(), condition.getEndurance(),
                condition.getCharm(), condition.getLuck());
        Integer rewId = questRepository.setReward(rewDescription, reward.getPower(), reward.getIntellect(),
                reward.getWillpower(), reward.getDexterity(), reward.getSpeed(), reward.getEndurance(),
                reward.getCharm(), reward.getLuck());
        questRepository.addQuest(name, guildRepository.findByAdminName(adminName).getName(), description, condId, rewId);
        return true;
    }

}
