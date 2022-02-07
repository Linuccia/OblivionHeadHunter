package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findByGuildName(String guildName);
    Optional<Request> findById(Integer id);

    @Query(value = "select count(*) from consider_end_quest_request(:requestId, :decision)", nativeQuery = true)
    void considerEndQuest(Integer requestId, String decision);

    @Query(value = "select count(*) from consider_enter_guild_request(:requestId, :decision, :rang)", nativeQuery = true)
    void considerEnterGuild(Integer requestId, String decision, String rang);

    @Query(value = "select count(*) from enter_guild_request(:heroName, :guildName)", nativeQuery = true)
    void enterGuildRequest(String heroName, String guildName);

}
