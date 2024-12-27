package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;
public class DestroyItem extends ClientPacket
{
	public int count;
	public byte slotNum;
	public byte containerId;
	public destroyItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        count = this.readUInt();
        containerId = this.readUInt8();
        slotNum = this.readUInt8();
	}
}
