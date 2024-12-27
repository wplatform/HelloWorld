package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.*;
public class RequestVehicleNextSeat extends ClientPacket
{
	public RequestVehicleNextSeat(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
