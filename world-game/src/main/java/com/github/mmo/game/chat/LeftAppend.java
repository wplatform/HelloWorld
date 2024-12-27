package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class LeftAppend implements IChannelAppender
{
	public LeftAppend()
	{
	}

	public LeftAppend(ObjectGuid guid)
	{
		guid = guid;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.LeftNotice;
	}

	public void append(ChannelNotify data)
	{
		data.senderGuid = guid;
	}

	private final ObjectGuid guid;

	public LeftAppend clone()
	{
		LeftAppend varCopy = new LeftAppend();

		varCopy.guid = this.guid;

		return varCopy;
	}
}
