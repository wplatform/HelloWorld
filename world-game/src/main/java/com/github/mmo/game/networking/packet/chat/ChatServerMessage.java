package com.github.mmo.game.networking.packet.chat;
import com.github.mmo.game.networking.ServerPacket;
public class ChatServerMessage extends ServerPacket
{
	public int messageID;
	public String stringParam = "";
	public ChatServerMessage()
	{
		super(ServerOpcode.ChatServerMessage);
	}

	@Override
	public void write()
	{
		this.writeInt32(messageID);

		this.writeBits(stringParam.GetByteCount(), 11);
		this.writeString(stringParam);
	}
}
