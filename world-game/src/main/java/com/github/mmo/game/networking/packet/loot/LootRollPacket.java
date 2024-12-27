package com.github.mmo.game.networking.packet.loot;


import com.github.mmo.game.networking.*;

class LootRollPacket extends ClientPacket
{
	public ObjectGuid lootObj = ObjectGuid.EMPTY;
	public byte lootListID;
	public RollVote rollType = RollVote.values()[0];
	public LootRollPacket(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		lootObj = this.readPackedGuid();
		lootListID = this.readUInt8();
		rollType = RollVote.forValue(this.readUInt8());
	}
}
