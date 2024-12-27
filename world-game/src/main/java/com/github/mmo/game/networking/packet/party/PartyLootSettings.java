package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;

final class PartyLootSettings
{
	public void write(WorldPacket data)
	{
		data.writeInt8(method);
		data.writeGuid(lootMaster);
		data.writeInt8(threshold);
	}

	public byte method;
	public ObjectGuid lootMaster = ObjectGuid.EMPTY;
	public byte threshold;

	public PartyLootSettings clone()
	{
		PartyLootSettings varCopy = new PartyLootSettings();

		varCopy.method = this.method;
		varCopy.lootMaster = this.lootMaster;
		varCopy.threshold = this.threshold;

		return varCopy;
	}
}
