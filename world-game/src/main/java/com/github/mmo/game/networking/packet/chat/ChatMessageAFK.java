package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.*;
public class ChatMessageAFK extends ClientPacket
{
	public String text;
	public ChatMessageAFK(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var len = this.<Integer>readBit(11);
		text = this.readString(len);
	}
}
