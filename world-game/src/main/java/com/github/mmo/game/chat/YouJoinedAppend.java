package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class YouJoinedAppend implements IChannelAppender
{
	public YouJoinedAppend()
	{
	}

	public YouJoinedAppend(Channel channel)
	{
		channel = channel;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.YouJoinedNotice;
	}

	public void append(ChannelNotify data)
	{
		data.chatChannelID = (int)channel.getChannelId();
	}

	private final Channel channel;

	public YouJoinedAppend clone()
	{
		YouJoinedAppend varCopy = new YouJoinedAppend();

		varCopy.channel = this.channel;

		return varCopy;
	}
}
