package com.github.mmo.game.scripting.interfaces.iconversation;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IConversationOnConversationLineStarted extends IScriptObject {
    void OnConversationLineStarted(Conversation conversation, int lineId, Player sender);
}
