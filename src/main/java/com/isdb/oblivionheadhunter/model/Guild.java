package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "гильдии")
@Data
public class Guild {

    @Id
    @Column(name = "название")
    private String name;
    @Column(name = "глава_ид")
    private String adminName;

}
