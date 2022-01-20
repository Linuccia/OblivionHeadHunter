package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "Заявки")
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_generator")
    @SequenceGenerator(name="request_generator", sequenceName = "заявки_ids", allocationSize=1)
    @Column(name = "ид")
    private Integer id;
    @Column(name = "тип")
    private String type;
    @Column(name = "герой_имя")
    private String heroName;
    @Column(name = "гильдия_название")
    private String guildName;
    @Column(name = "описание")
    private String description;

}
