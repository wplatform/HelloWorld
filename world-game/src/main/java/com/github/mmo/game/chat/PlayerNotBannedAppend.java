package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class PlayerNotBannedAppend implements IChannelAppender
{
	public PlayerNotBannedAppend()
	{
	}

	public PlayerNotBannedAppend(String playerName)
	{
		playerName = playerName;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.PlayerNotBannedNotice;
	}

	public void append(ChannelNotify data)
	{
		data.sender = playerName;
	}

	private final String playerName;

	public PlayerNotBannedAppend clone()
	{
		PlayerNotBannedAppend varCopy = new PlayerNotBannedAppend();

		varCopy.playerName = this.playerName;

		return varCopy;
	}
}