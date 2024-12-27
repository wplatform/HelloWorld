package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class YouLeftAppend implements IChannelAppender
{
	public YouLeftAppend()
	{
	}

	public YouLeftAppend(Channel channel)
	{
		channel = channel;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.YouLeftNotice;
	}

	public void append(ChannelNotify data)
	{
		data.chatChannelID = (int)channel.getChannelId();
	}

	private final Channel channel;

	public YouLeftAppend clone()
	{
		YouLeftAppend varCopy = new YouLeftAppend();

		varCopy.channel = this.channel;

		return varCopy;
	}
}
