package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Квесты")
@Data
public class Quest {

    @Id
    @Column(name = "название")
    private String name;
    @Column(name = "гильдия_название")
    private String guildName;
    @Column(name = "описание")
    private String description;
    @Column(name = "условия_взятия")
    private Integer conditions;
    @Column(name = "награда")
    private Integer reward;
    @Column(name = "герой_имя")
    private String heroName;
    @Column(name = "статус")
    private String status;

}
