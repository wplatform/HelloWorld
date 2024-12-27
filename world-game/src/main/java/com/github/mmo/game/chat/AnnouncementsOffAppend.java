package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class AnnouncementsOffAppend implements IChannelAppender
{
	public AnnouncementsOffAppend()
	{
	}

	public AnnouncementsOffAppend(ObjectGuid guid)
	{
		guid = guid;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.AnnouncementsOffNotice;
	}

	public void append(ChannelNotify data)
	{
		data.senderGuid = guid;
	}

	private final ObjectGuid guid;

	public AnnouncementsOffAppend clone()
	{
		AnnouncementsOffAppend varCopy = new AnnouncementsOffAppend();

		varCopy.guid = this.guid;

		return varCopy;
	}
}
