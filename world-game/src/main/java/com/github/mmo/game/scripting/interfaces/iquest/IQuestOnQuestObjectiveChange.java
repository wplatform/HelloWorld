package com.github.mmo.game.scripting.interfaces.iquest;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IQuestOnQuestObjectiveChange extends IScriptObject {
    void OnQuestObjectiveChange(Player player, Quest quest, QuestObjective objective, int oldAmount, int newAmount);
}
