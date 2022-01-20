package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.QuestReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RewardRepository extends JpaRepository<QuestReward, Integer> {

    Optional<QuestReward> findById(Integer id);

}
