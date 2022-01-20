package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Расы")
@Data
public class Race {

    @Id
    @Column(name = "название")
    private String name;
    @Column(name = "описание")
    private String description;
    @Column(name = "атрибуты_ид")
    private Long attributes;

}
