package com.isdb.oblivionheadhunter.model.pojo;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.Quest;
import lombok.Data;

@Data
public class NewQuest {

    private Quest quest;
    private Integer minLevel;
    private Attributes condition;
    private String rewardDescription;
    private Attributes reward;

}
