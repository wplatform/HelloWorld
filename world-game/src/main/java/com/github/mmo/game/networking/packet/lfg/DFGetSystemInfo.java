package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.*;
class DFGetSystemInfo extends ClientPacket
{
	public byte partyIndex;
	public boolean player;
	public DFGetSystemInfo(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		player = this.readBit();
		partyIndex = this.readUInt8();
	}
}
