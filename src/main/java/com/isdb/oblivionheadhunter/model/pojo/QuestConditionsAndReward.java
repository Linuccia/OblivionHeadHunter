package com.isdb.oblivionheadhunter.model.pojo;

import com.isdb.oblivionheadhunter.model.Attributes;
import com.isdb.oblivionheadhunter.model.QuestCondition;
import com.isdb.oblivionheadhunter.model.QuestReward;
import lombok.Data;

@Data
public class QuestConditionsAndReward {

    private QuestCondition condition;
    private Attributes condAttributes;
    private QuestReward reward;
    private Attributes rewAttributes;

}
