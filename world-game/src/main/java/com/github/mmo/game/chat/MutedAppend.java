package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class MutedAppend implements IChannelAppender
{
	public ChatNotify getNotificationType()
	{
		return ChatNotify.MutedNotice;
	}

	public void append(ChannelNotify data)
	{
	}
}
