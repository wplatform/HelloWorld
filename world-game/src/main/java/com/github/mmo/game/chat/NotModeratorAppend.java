package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class NotModeratorAppend implements IChannelAppender
{
	public ChatNotify getNotificationType()
	{
		return ChatNotify.NotModeratorNotice;
	}

	public void append(ChannelNotify data)
	{
	}
}
