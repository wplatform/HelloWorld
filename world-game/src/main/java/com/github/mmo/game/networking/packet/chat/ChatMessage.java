package com.github.mmo.game.networking.packet.chat;


import com.github.mmo.game.networking.*;

public class ChatMessage extends ClientPacket
{
	public String text;
	public language language = language.Universal;
	public ChatMessage(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        language = language.forValue(this.readInt32());
        var len = this.<Integer>readBit(11);
        text = this.readString(len);
	}
}
