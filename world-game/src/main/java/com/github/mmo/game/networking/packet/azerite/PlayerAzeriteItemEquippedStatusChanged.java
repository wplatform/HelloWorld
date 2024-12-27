package com.github.mmo.game.networking.packet.azerite;
import com.github.mmo.game.networking.ServerPacket;
public class PlayerAzeriteItemEquippedStatusChanged extends ServerPacket
{
	public boolean isHeartEquipped;
	public PlayerAzeriteItemEquippedStatusChanged()
	{
		super(ServerOpcode.PlayerAzeriteItemEquippedStatusChanged);
	}

	@Override
	public void write()
	{
		this.writeBit(isHeartEquipped);
		this.flushBits();
	}
}
