package com.github.mmo.game.networking.packet.battlepet;


import com.github.mmo.game.networking.*;

class BattlePetSetFlags extends ClientPacket
{
	public ObjectGuid petGuid = ObjectGuid.EMPTY;
	public int flags;
	public FlagscontrolType controlType = FlagsControlType.values()[0];
	public BattlePetSetFlags(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		petGuid = this.readPackedGuid();
		flags = this.readUInt();
		controlType = FlagsControlType.forValue(this.<Byte>readBit(2));
	}
}
