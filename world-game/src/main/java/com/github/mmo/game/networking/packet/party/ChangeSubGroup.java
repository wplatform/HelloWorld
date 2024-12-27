package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;

class ChangeSubGroup extends ClientPacket
{
	public ObjectGuid targetGUID = ObjectGuid.EMPTY;
	public byte partyIndex;
	public byte newSubGroup;
	public ChangeSubGroup(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		targetGUID = this.readPackedGuid();
		partyIndex = this.readByte();
		newSubGroup = this.readUInt8();
	}
}
