package com.github.mmo.game.networking.packet.item;


import com.github.mmo.game.networking.*;

class SocketGems extends ClientPacket
{
	public ObjectGuid itemGuid = ObjectGuid.EMPTY;
	public ObjectGuid[] gemItem = new ObjectGuid[ItemConst.MaxGemSockets];
	public SocketGems(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		itemGuid = this.readPackedGuid();

		for (var i = 0; i < ItemConst.MaxGemSockets; ++i)
		{
			GemItem[i] = this.readPackedGuid();
		}
	}
}
