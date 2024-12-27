package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
public final class AuraInfo
{
	public void write(WorldPacket data)
	{
		data.writeInt8(slot);
        data.writeBit(auraData != null);
        data.flushBits();

		if (auraData != null)
		{
			auraData.write(data);
		}
	}

	public byte slot;
	public auraDataInfo auraData;

	public AuraInfo clone()
	{
		AuraInfo varCopy = new AuraInfo();

		varCopy.slot = this.slot;
		varCopy.auraData = this.auraData;

		return varCopy;
	}
}
