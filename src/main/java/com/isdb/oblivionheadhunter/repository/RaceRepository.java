package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, String> {

    Race findByName(String name);

}
