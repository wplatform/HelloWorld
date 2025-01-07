package com.github.azeroth.game.scripting.interfaces.iquest;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IQuestOnQuestStatusChange extends IScriptObject {
    void OnQuestStatusChange(Player player, Quest quest, QuestStatus oldStatus, QuestStatus newStatus);
}
