package com.github.azeroth.game.domain.quest;


import com.github.azeroth.common.LocalizedString;

public class QuestConditionalText {
    public int playerConditionId;
    public int questGiverCreatureId;
    public LocalizedString text = new LocalizedString();
}
