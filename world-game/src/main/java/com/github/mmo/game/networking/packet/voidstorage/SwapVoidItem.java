package com.github.mmo.game.networking.packet.voidstorage;

import com.github.mmo.game.networking.*;

class SwapVoidItem extends ClientPacket
{
	public ObjectGuid npc = ObjectGuid.EMPTY;
	public ObjectGuid voidItemGuid = ObjectGuid.EMPTY;
	public int dstSlot;
	public SwapVoidItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		npc = this.readPackedGuid();
		voidItemGuid = this.readPackedGuid();
		dstSlot = this.readUInt();
	}
}