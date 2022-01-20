package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends JpaRepository<Quest, String> {

    Quest findByName(String name);
    List<Quest> findByHeroName(String heroName);
    List<Quest> findByGuildNameAndStatus(String guildName, String status);

    @Query(value = "select count(*) from add_quest(:name, :guildName, :description, :condId, :rewId)", nativeQuery = true)
    void addQuest(String name, String guildName, String description, Integer condId, Integer rewId);

    @Query(value = "select count(*) from end_quest_request(:questName, :result, :description)", nativeQuery = true)
    void endQuestRequest(String questName, String result, String description);

    @Query(value = "select * from get_quest(:questName, :heroName)", nativeQuery = true)
    boolean takeQuest(String questName, String heroName);

    @Query(value = "select * from set_conditions(:minLevel, :power, :intellect, :willpower, :dexterity, " +
            ":speed, :endurance, :charm, :luck)", nativeQuery = true)
    Integer setConditions(Integer minLevel, Integer power, Integer intellect, Integer willpower, Integer dexterity,
                          Integer speed, Integer endurance, Integer charm, Integer luck);

    @Query(value = "select * from set_reward(:description, :power, :intellect, :willpower, :dexterity, " +
            ":speed, :endurance, :charm, :luck)", nativeQuery = true)
    Integer setReward(String description, Integer power, Integer intellect, Integer willpower, Integer dexterity,
                      Integer speed, Integer endurance, Integer charm, Integer luck);

}
