package com.github.mmo.game.networking.packet.spell;


public class ClearSpellCharges extends ServerPacket
{
	public boolean isPet;
	public int category;
	public ClearSpellCharges()
	{
		super(ServerOpcode.ClearSpellCharges, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(category);
		this.writeBit(isPet);
		this.flushBits();
	}
}
