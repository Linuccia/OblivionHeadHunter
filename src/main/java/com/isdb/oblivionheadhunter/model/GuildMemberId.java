package com.isdb.oblivionheadhunter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GuildMemberId implements Serializable {

    @Column(name = "гильдия_название")
    private String guildName;
    @Column(name = "герой_имя")
    private String heroName;

}
