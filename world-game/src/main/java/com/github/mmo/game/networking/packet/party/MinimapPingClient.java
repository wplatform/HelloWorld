package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;
class MinimapPingClient extends ClientPacket
{
	public byte partyIndex;
	public float positionX;
	public float positionY;
	public MinimapPingClient(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		positionX = this.readFloat();
		positionY = this.readFloat();
		partyIndex = this.readByte();
	}
}
