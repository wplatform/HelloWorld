package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class WrongFactionAppend implements IChannelAppender
{
	public ChatNotify getNotificationType()
	{
		return ChatNotify.WrongFactionNotice;
	}

	public void append(ChannelNotify data)
	{
	}
}
