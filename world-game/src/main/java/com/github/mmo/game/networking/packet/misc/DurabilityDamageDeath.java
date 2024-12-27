package com.github.mmo.game.networking.packet.misc;
import com.github.mmo.game.networking.ServerPacket;
public class DurabilityDamageDeath extends ServerPacket
{
	public int percent;
	public DurabilityDamageDeath()
	{
		super(ServerOpcode.DurabilityDamageDeath);
	}

	@Override
	public void write()
	{
        this.writeInt32(percent);
	}
}
