package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.*;

public class RequestVehicleSwitchSeat extends ClientPacket
{
	public ObjectGuid vehicle = ObjectGuid.EMPTY;
	public byte seatIndex = (byte)255;
	public RequestVehicleSwitchSeat(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		vehicle = this.readPackedGuid();
		seatIndex = this.readUInt8();
	}
}
