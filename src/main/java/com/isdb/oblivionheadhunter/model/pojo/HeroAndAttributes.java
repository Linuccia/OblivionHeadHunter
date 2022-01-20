package com.isdb.oblivionheadhunter.model.pojo;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.Hero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeroAndAttributes {

    private Hero hero;
    private Attributes attributes;

}
