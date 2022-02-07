package com.isdb.oblivionheadhunter.service;

import com.isdb.oblivionheadhunter.model.Guild;
import com.isdb.oblivionheadhunter.model.GuildMember;
import com.isdb.oblivionheadhunter.model.GuildMemberId;
import com.isdb.oblivionheadhunter.model.Quest;
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
public class GuildService {

    private final GuildMemberRepository memberRepository;
    private final QuestRepository questRepository;
    private final RequestRepository requestRepository;
    private final GuildRepository guildRepository;

    public List<GuildMember> getGuildMembers(String guildName) {
        return memberRepository.findByIdGuildName(guildName);
    }

    public GuildMember getMemberByHeroNameAndGuildName(String heroName, String guildName) {
        GuildMemberId id = new GuildMemberId(guildName, heroName);
        return memberRepository.findById(id).orElse(null);
    }

    public List<Quest> getGuildQuests(String guildName) {
        List<Quest> list = new ArrayList<>();
        list.addAll(questRepository.findByGuildNameAndStatus(guildName, null));
        list.addAll(questRepository.findByGuildNameAndStatus(guildName, "начат"));
        return list;
    }

    public boolean checkGuildMember(String heroName, String guildName) {
        GuildMemberId id = new GuildMemberId(guildName, heroName);
        return memberRepository.findById(id).isPresent();
    }

    public Guild checkLeader(String heroName, String guildName) {
        return guildRepository.findByAdminName(heroName);
    }

    public void enterGuild(String heroName, String guildName) {
        requestRepository.enterGuildRequest(heroName, guildName);
    }

}
