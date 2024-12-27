package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class InviteAppend implements IChannelAppender
{
	public InviteAppend()
	{
	}

	public InviteAppend(ObjectGuid guid)
	{
		guid = guid;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.InviteNotice;
	}

	public void append(ChannelNotify data)
	{
		data.senderGuid = guid;
	}

	private final ObjectGuid guid;

	public InviteAppend clone()
	{
		InviteAppend varCopy = new InviteAppend();

		varCopy.guid = this.guid;

		return varCopy;
	}
}
