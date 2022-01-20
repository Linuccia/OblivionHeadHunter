package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.GuildMember;
import com.isdb.oblivionheadhunter.model.GuildMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuildMemberRepository extends JpaRepository<GuildMember, GuildMemberId> {

    Optional<GuildMember> findById(GuildMemberId id);
    List<GuildMember> findByIdGuildName(String guildName);

    @Query(value = "select count(*) from change_rang(:heroName, :guildName, :rang)", nativeQuery = true)
    void changeRang(String heroName, String guildName, String rang);

}
