package com.github.mmo.game.chat;


import com.github.mmo.game.entity.object.WorldObject;

class CypherStringChatBuilder extends MessageBuilder
{
	private final WorldObject source;
	private final ChatMsg msgType;
	private final CypherStrings textId;
	private final WorldObject target;
	private final Object[] args;


	public CypherStringChatBuilder(WorldObject obj, ChatMsg msgType, CypherStrings textId, WorldObject target)
	{
		this(obj, msgType, textId, target, null);
	}

	public CypherStringChatBuilder(WorldObject obj, ChatMsg msgType, CypherStrings textId)
	{
		this(obj, msgType, textId, null, null);
	}

	public CypherStringChatBuilder(WorldObject obj, ChatMsg msgType, CypherStrings textId, WorldObject target, Object[] args)
	{
		source = obj;
		msgType = msgType;
		textId = textId;
		target = target;
		args = args;
	}

	@Override
	public ChatPacketSender invoke(Locale locale)
	{
		var text = global.getObjectMgr().getCypherString(textId, locale);

		if (args != null)
		{
			return new ChatPacketSender(msgType, language.Universal, source, target, String.format(text, args), 0, locale);
		}
		else
		{
			return new ChatPacketSender(msgType, language.Universal, source, target, text, 0, locale);
		}
	}
}
