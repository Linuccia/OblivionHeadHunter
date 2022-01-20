package com.isdb.oblivionheadhunter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table (name = "Герои")
@Data
public class Hero {

    @Id
    @Column(name = "имя")
    private String name;
    @Column(name = "пол")
    private String gender;
    @Column(name = "уровень")
    private Integer level;
    @Column(name = "раса_название")
    private String race;
    @Column(name = "класс_название")
    private String heroClass;
    @Column(name = "созвездие_название")
    private String galaxy;
    @Column(name = "атрибуты_ид")
    private Long attributes;


}
