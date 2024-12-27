package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class NotInAreaAppend implements IChannelAppender
{
	public ChatNotify getNotificationType()
	{
		return ChatNotify.NotInAreaNotice;
	}

	public void append(ChannelNotify data)
	{
	}
}
