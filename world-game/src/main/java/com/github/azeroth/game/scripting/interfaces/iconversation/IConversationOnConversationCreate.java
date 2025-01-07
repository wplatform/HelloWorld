package com.github.azeroth.game.scripting.interfaces.iconversation;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IConversationOnConversationCreate extends IScriptObject {
    void OnConversationCreate(Conversation conversation, Unit creator);
}
