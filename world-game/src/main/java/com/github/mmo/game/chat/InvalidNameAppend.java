package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class InvalidNameAppend implements IChannelAppender
{
	public ChatNotify getNotificationType()
	{
		return ChatNotify.InvalidNameNotice;
	}

	public void append(ChannelNotify data)
	{
	}
}
