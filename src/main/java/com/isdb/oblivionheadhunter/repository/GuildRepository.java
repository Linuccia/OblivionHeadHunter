package com.isdb.oblivionheadhunter.repository;

import com.isdb.oblivionheadhunter.model.Guild;
import com.isdb.oblivionheadhunter.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends JpaRepository<Guild, String> {

    Guild findByAdminName(String adminName);

}
