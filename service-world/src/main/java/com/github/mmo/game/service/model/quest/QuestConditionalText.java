package com.github.mmo.game.service.model.quest;


import com.github.mmo.common.LocalizedString;

public class QuestConditionalText {
    public int playerConditionId;
    public int questGiverCreatureId;
    public LocalizedString text = new LocalizedString();
}
