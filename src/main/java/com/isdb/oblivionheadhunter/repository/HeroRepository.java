package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {

    Hero findByName(String name);

}
