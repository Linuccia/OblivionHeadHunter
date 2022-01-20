package com.isdb.oblivionheadhunter.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table (name = "Атрибуты")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attributes_generator")
    @SequenceGenerator(name="attributes_generator", sequenceName = "атрибуты_ids", allocationSize=1)
    @Column(name = "ид")
    private Long id;
    @Column(name = "сила")
    private Integer power;
    @Column(name = "интеллект")
    private Integer intellect;
    @Column(name = "сила_воли")
    private Integer willpower;
    @Column(name = "ловкость")
    private Integer dexterity;
    @Column(name = "скорость")
    private Integer speed;
    @Column(name = "выносливость")
    private Integer endurance;
    @Column(name = "обаяние")
    private Integer charm;
    @Column(name = "удача")
    private Integer luck;

}
