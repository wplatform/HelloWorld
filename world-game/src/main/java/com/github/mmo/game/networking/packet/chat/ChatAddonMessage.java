package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.*;
import io.netty.buffer.ByteBuf;

public class ChatAddonMessage extends ClientPacket
{
	public ChatAddonMessageParams params = new ChatAddonMessageParams();
	public ChatAddonMessage(ByteBuf packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		params.read(this);
	}
}
