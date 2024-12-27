package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;

class RemoveNewItem extends ClientPacket
{
	private ObjectGuid itemGuid = ObjectGuid.EMPTY;
	public final ObjectGuid getItemGuid()
	{
		return itemGuid;
	}
	public final void setItemGuid(ObjectGuid value)
	{
		itemGuid = value;
	}
	public RemoveNewItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		setItemGuid(this.readPackedGuid());
	}
}
