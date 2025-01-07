package com.github.azeroth.game.scripting.interfaces.iconversation;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IConversationOnConversationLineStarted extends IScriptObject {
    void OnConversationLineStarted(Conversation conversation, int lineId, Player sender);
}
