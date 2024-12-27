package com.github.mmo.game.service.domain.quest;


import com.github.mmo.common.LocalizedString;

public class QuestConditionalText {
    public int playerConditionId;
    public int questgiverCreatureId;
    public LocalizedString text = new LocalizedString();
}
