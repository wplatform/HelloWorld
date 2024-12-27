package com.github.mmo.game.networking.packet.achievement;


public class CriteriaDeleted extends ServerPacket
{
	public int criteriaID;
	public CriteriaDeleted()
	{
		super(ServerOpcode.CriteriaDeleted, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(criteriaID);
	}
}
