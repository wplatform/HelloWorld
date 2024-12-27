package com.github.mmo.game.scripting.interfaces.iquest;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IQuestOnQuestStatusChange extends IScriptObject
{
	void OnQuestStatusChange(Player player, Quest quest, QuestStatus oldStatus, QuestStatus newStatus);
}
