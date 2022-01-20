package com.isdb.oblivionheadhunter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "Условия_Взятия")
@Data
public class QuestCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conditions_generator")
    @SequenceGenerator(name="conditions_generator", sequenceName = "условия_ids", allocationSize=1)
    @Column(name = "ид")
    private Integer id;
    @Column(name = "мин_уровень")
    private Integer minLevel;
    @Column(name = "атрибуты_ид")
    private Long attributes;

}
