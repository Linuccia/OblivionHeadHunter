package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.QuestCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionsRepository extends JpaRepository<QuestCondition, Integer> {

    Optional<QuestCondition> findById(Integer id);

}
