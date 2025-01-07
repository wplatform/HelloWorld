package com.github.azeroth.game.scripting.interfaces.iquest;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IQuestOnQuestObjectiveChange extends IScriptObject {
    void OnQuestObjectiveChange(Player player, Quest quest, QuestObjective objective, int oldAmount, int newAmount);
}
