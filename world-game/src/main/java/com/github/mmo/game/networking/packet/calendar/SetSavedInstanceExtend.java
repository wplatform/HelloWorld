package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.*;
class SetSavedInstanceExtend extends ClientPacket
{
	public int mapID;
	public boolean extend;
	public int difficultyID;
	public SetSavedInstanceExtend(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        mapID = this.readInt32();
        difficultyID = this.readUInt();
        extend = this.readBit();
	}
}