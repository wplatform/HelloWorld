package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class PlayerNotFoundAppend implements IChannelAppender
{
	public PlayerNotFoundAppend()
	{
	}

	public PlayerNotFoundAppend(String playerName)
	{
		playerName = playerName;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.PlayerNotFoundNotice;
	}

	public void append(ChannelNotify data)
	{
		data.sender = playerName;
	}

	private final String playerName;

	public PlayerNotFoundAppend clone()
	{
		PlayerNotFoundAppend varCopy = new PlayerNotFoundAppend();

		varCopy.playerName = this.playerName;

		return varCopy;
	}
}
