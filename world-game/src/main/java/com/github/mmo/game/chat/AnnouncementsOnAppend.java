package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class AnnouncementsOnAppend implements IChannelAppender
{
	public AnnouncementsOnAppend()
	{
	}

	public AnnouncementsOnAppend(ObjectGuid guid)
	{
		guid = guid;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.AnnouncementsOnNotice;
	}

	public void append(ChannelNotify data)
	{
		data.senderGuid = guid;
	}

	private final ObjectGuid guid;

	public AnnouncementsOnAppend clone()
	{
		AnnouncementsOnAppend varCopy = new AnnouncementsOnAppend();

		varCopy.guid = this.guid;

		return varCopy;
	}
}
