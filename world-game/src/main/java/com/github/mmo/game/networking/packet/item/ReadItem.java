package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;
class ReadItem extends ClientPacket
{
	public byte packSlot;
	public byte slot;
	public ReadItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		packSlot = this.readUInt8();
		slot = this.readUInt8();
	}
}
