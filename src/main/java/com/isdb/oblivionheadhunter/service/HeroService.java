package com.isdb.oblivionheadhunter.service;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.Hero;
import com.isdb.oblivionheadhunter.model.Quest;
import com.isdb.oblivionheadhunter.repository.AttributesRepository;
import com.isdb.oblivionheadhunter.repository.HeroRepository;
import com.isdb.oblivionheadhunter.repository.QuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;
    private final AttributesRepository attrRepository;
    private final QuestRepository questRepository;

    public Hero getHero(String name) {
        return heroRepository.findByName(name);
    }

    public Attributes getHeroAttributes(Long heroId) {
        return attrRepository.getById(heroId);
    }

    public List<Quest> getHeroQuests(String heroName) {
        return questRepository.findByHeroName(heroName);
    }

}
