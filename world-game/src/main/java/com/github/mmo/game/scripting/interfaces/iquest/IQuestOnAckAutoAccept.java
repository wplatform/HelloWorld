package com.github.mmo.game.scripting.interfaces.iquest;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IQuestOnAckAutoAccept extends IScriptObject {
    void OnAcknowledgeAutoAccept(Player player, Quest quest);
}
