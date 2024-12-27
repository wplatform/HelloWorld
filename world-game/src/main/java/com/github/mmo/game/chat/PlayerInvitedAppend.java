package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class PlayerInvitedAppend implements IChannelAppender
{
	public PlayerInvitedAppend()
	{
	}

	public PlayerInvitedAppend(String playerName)
	{
		playerName = playerName;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.PlayerInvitedNotice;
	}

	public void append(ChannelNotify data)
	{
		data.sender = playerName;
	}

	private final String playerName;

	public PlayerInvitedAppend clone()
	{
		PlayerInvitedAppend varCopy = new PlayerInvitedAppend();

		varCopy.playerName = this.playerName;

		return varCopy;
	}
}
