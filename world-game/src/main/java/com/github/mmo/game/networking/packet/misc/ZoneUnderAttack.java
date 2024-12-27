package com.github.mmo.game.networking.packet.misc;


public class ZoneUnderAttack extends ServerPacket
{
	public int areaID;
	public ZoneUnderAttack()
	{
		super(ServerOpcode.ZoneUnderAttack, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(areaID);
	}
}
