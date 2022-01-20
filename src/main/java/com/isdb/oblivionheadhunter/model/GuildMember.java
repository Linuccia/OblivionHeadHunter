package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Гильдии_Составы")
@Data
public class GuildMember {

    @EmbeddedId
    private GuildMemberId id;
    @Column (name = "ранг")
    private String rang;

}
