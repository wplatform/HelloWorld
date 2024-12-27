package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class OwnerChangedAppend implements IChannelAppender
{
	public OwnerChangedAppend()
	{
	}

	public OwnerChangedAppend(ObjectGuid guid)
	{
		guid = guid;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.OwnerChangedNotice;
	}

	public void append(ChannelNotify data)
	{
		data.senderGuid = guid;
	}

	private final ObjectGuid guid;

	public OwnerChangedAppend clone()
	{
		OwnerChangedAppend varCopy = new OwnerChangedAppend();

		varCopy.guid = this.guid;

		return varCopy;
	}
}
