package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class ModeChangeAppend implements IChannelAppender
{
	public ModeChangeAppend()
	{
	}

	public ModeChangeAppend(ObjectGuid guid, ChannelMemberFlags oldFlags, ChannelMemberFlags newFlags)
	{
		guid = guid;
		oldFlags = oldFlags;
		newFlags = newFlags;
	}

	public ChatNotify getNotificationType()
	{
		return ChatNotify.ModeChangeNotice;
	}

	public void append(ChannelNotify data)
	{
		data.senderGuid = guid;
		data.oldFlags = oldFlags;
		data.newFlags = newFlags;
	}

	private final ObjectGuid guid;
	private final ChannelMemberFlags oldFlags;
	private final ChannelMemberFlags newFlags;

	public ModeChangeAppend clone()
	{
		ModeChangeAppend varCopy = new ModeChangeAppend();

		varCopy.guid = this.guid;
		varCopy.oldFlags = this.oldFlags;
		varCopy.newFlags = this.newFlags;

		return varCopy;
	}
}
