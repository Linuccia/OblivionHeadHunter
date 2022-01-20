package com.isdb.oblivionheadhunter.service;

import com.isdb.oblivionheadhunter.model.*;
import com.isdb.oblivionheadhunter.repository.*;
import com.isdb.oblivionheadhunter.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final HeroRepository heroRepository;
    private final AttributesRepository attrRepository;
    private final RaceRepository raceRepository;
    private final HeroClassRepository classRepository;
    private final GalaxyRepository galaxyRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean addHero(Hero hero) {
        if (heroRepository.findByName(hero.getName()) != null) return false;
        Long raceAttrId = raceRepository.findByName(hero.getRace()).getAttributes();
        Long classAttrId = classRepository.findByName(hero.getHeroClass()).getAttributes();
        Long constAttrId = galaxyRepository.findByName(hero.getGalaxy()).getAttributes();
        Attributes raceAttr = attrRepository.findById(raceAttrId).orElse(null);
        Attributes classAttr = attrRepository.findById(classAttrId).orElse(null);
        Attributes constAttr = attrRepository.findById(constAttrId).orElse(null);
        Attributes attributes = Attributes.builder()
                .power(raceAttr.getPower() + classAttr.getPower() + constAttr.getPower())
                .intellect(raceAttr.getIntellect() + classAttr.getIntellect() + constAttr.getIntellect())
                .willpower(raceAttr.getWillpower() + classAttr.getWillpower() + constAttr.getWillpower())
                .dexterity(raceAttr.getDexterity() + classAttr.getDexterity() + constAttr.getDexterity())
                .speed(raceAttr.getSpeed() + classAttr.getSpeed() + constAttr.getSpeed())
                .endurance(raceAttr.getEndurance() + classAttr.getEndurance() + constAttr.getEndurance())
                .charm(raceAttr.getCharm() + classAttr.getCharm() + constAttr.getCharm())
                .luck(raceAttr.getLuck() + classAttr.getLuck() + constAttr.getLuck())
                .build();
        attributes = attrRepository.save(attributes);
        hero.setAttributes(attributes.getId());
        heroRepository.save(hero);
        return true;
    }

    public void saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) return;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoleDB("обычный");
        userRepository.save(user);
    }

    public List<Race> getRaces() {
        return raceRepository.findAll();
    }

    public List<HeroClass> getClasses() {
        return classRepository.findAll();
    }

    public List<Galaxy> getGalaxies() {
        return galaxyRepository.findAll();
    }

}
