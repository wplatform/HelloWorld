package com.github.mmo.game.networking.packet.chat;
import com.github.mmo.game.networking.ServerPacket;
public class ChatRestricted extends ServerPacket
{
	private final ChatRestrictionType reason;

	public ChatRestricted(ChatRestrictionType reason)
	{
		super(ServerOpcode.ChatRestricted);
		reason = reason;
	}

	@Override
	public void write()
	{
		this.writeInt8((byte)reason.getValue());
	}
}
