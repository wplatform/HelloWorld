package com.github.mmo.game.scripting.interfaces.iconversation;

import com.github.mmo.game.entity.conversation;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IConversationOnConversationCreate extends IScriptObject
{
	void OnConversationCreate(Conversation conversation, Unit creator);
}
