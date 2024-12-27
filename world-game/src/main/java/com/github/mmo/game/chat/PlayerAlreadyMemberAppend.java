package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class PlayerAlreadyMemberAppend implements IChannelAppender
{
	public PlayerAlreadyMemberAppend()
	{
	}

	public PlayerAlreadyMemberAppend(ObjectGuid guid)
	{
        guid = guid;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.PlayerAlreadyMemberNotice;
	}

	public void append(ChannelNotify data)
	{
        data.senderGuid = guid;
	}

	private final ObjectGuid guid;

	public PlayerAlreadyMemberAppend clone()
	{
		PlayerAlreadyMemberAppend varCopy = new PlayerAlreadyMemberAppend();

        varCopy.guid = this.guid;

		return varCopy;
	}
}
