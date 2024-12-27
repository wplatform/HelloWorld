package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;
public class AutoEquipItem extends ClientPacket
{
	public byte slot;
	public invUpdate inv = new invUpdate();
	public byte packSlot;
	public AutoEquipItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		inv = new invUpdate(this);
        packSlot = this.readUInt8();
        slot = this.readUInt8();
	}
}
