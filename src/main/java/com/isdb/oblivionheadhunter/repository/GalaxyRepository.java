package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Galaxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalaxyRepository extends JpaRepository<Galaxy, String> {

    Galaxy findByName(String name);
    List<Galaxy> findAll();

}
