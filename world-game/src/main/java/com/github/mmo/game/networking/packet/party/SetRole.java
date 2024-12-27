package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.WorldPacket;

class SetRole extends ClientPacket
{
	public byte partyIndex;
    public ObjectGuid targetGUID = ObjectGuid.EMPTY;
	public int role;
	public SetRole(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        partyIndex = this.readByte();
        targetGUID = this.readPackedGuid();
        role = this.readInt32();
	}
}
