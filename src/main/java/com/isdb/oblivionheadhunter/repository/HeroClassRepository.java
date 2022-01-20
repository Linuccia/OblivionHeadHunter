package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroClassRepository extends JpaRepository<HeroClass, String> {

    HeroClass findByName(String name);

}
