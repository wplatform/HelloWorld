package com.github.mmo.game.networking.packet.token;

import com.github.mmo.game.networking.*;
class CommerceTokenGetLog extends ClientPacket
{
	public int unkInt;
	public CommerceTokenGetLog(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        unkInt = this.readUInt();
	}
}
