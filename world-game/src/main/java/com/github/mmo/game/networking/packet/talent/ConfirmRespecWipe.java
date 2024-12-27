package com.github.mmo.game.networking.packet.talent;


import com.github.mmo.game.networking.*;

class ConfirmRespecWipe extends ClientPacket
{
    public ObjectGuid respecMaster = ObjectGuid.EMPTY;
	public SpecResetType respecType = SpecResetType.values()[0];
	public ConfirmRespecWipe(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        respecMaster = this.readPackedGuid();
        respecType = SpecResetType.forValue(this.readUInt8());
	}
}
