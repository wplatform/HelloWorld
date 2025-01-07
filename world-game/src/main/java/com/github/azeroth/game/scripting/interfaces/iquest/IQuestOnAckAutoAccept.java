package com.github.azeroth.game.scripting.interfaces.iquest;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IQuestOnAckAutoAccept extends IScriptObject {
    void OnAcknowledgeAutoAccept(Player player, Quest quest);
}
