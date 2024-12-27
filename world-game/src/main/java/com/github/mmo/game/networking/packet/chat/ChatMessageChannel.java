package com.github.mmo.game.networking.packet.chat;


import com.github.mmo.game.networking.*;

public class ChatMessageChannel extends ClientPacket
{
	public language language = language.Universal;
    public ObjectGuid channelGUID = ObjectGuid.EMPTY;
	public String text;
	public String target;
	public ChatMessageChannel(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        language = language.forValue(this.readInt32());
        channelGUID = this.readPackedGuid();
        var targetLen = this.<Integer>readBit(9);
        var textLen = this.<Integer>readBit(11);
        target = this.readString(targetLen);
        text = this.readString(textLen);
	}
}
