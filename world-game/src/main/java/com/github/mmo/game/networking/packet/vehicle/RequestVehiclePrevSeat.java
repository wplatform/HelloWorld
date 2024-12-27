package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.*;
public class RequestVehiclePrevSeat extends ClientPacket
{
	public RequestVehiclePrevSeat(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
