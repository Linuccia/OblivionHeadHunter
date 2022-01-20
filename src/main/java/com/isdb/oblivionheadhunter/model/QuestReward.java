package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "Награды")
@Data
public class QuestReward {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reward_generator")
    @SequenceGenerator(name="reward_generator", sequenceName = "награды_ids", allocationSize=1)
    @Column(name = "ид")
    private Integer id;
    @Column(name = "описание")
    private String description;
    @Column(name = "атрибуты_ид")
    private Long attributes;

}
