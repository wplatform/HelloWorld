package com.github.mmo.game.networking.packet.achievement;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.*;

public final class CriteriaProgressPkt
{
    public ObjectGuid player = ObjectGuid.EMPTY;

	public int id;
	public long quantity;

	public void write(WorldPacket data)
	{
        data.writeInt32(id);
		data.writeInt64(quantity);
        data.writeGuid(player);
		data.writePackedTime(date);
        data.writeInt64(timeFromStart);
        data.writeInt64(timeFromCreate);
        data.writeBits(flags, 4);
        data.writeBit(rafAcceptanceID != null);
        data.flushBits();

		if (rafAcceptanceID != null)
		{
			data.writeInt64(rafAcceptanceID.longValue());
		}
	}
	public int flags;
	public long date;
	public long timeFromStart;
	public long timeFromCreate;
	public Long rafAcceptanceID = null;

	public CriteriaProgressPkt clone()
	{
		CriteriaProgressPkt varCopy = new criteriaProgressPkt();

		varCopy.id = this.id;
		varCopy.quantity = this.quantity;
        varCopy.player = this.player;
		varCopy.flags = this.flags;
		varCopy.date = this.date;
		varCopy.timeFromStart = this.timeFromStart;
		varCopy.timeFromCreate = this.timeFromCreate;
		varCopy.rafAcceptanceID = this.rafAcceptanceID;

		return varCopy;
	}
}