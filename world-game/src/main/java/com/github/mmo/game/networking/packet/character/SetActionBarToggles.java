package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
public class SetActionBarToggles extends ClientPacket
{
	public byte mask;
	public SetActionBarToggles(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		mask = this.readUInt8();
	}
}
