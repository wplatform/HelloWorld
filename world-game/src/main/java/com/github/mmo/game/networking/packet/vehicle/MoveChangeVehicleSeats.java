package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.movement.model.MovementInfo;
import com.github.mmo.game.networking.*;

public class MoveChangeVehicleSeats extends ClientPacket
{
	public ObjectGuid dstVehicle = ObjectGuid.EMPTY;
	public MovementInfo status;
	public byte dstSeatIndex = (byte)255;
	public MoveChangeVehicleSeats(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		status = MovementExtensions.readMovementInfo(this);
		dstVehicle = this.readPackedGuid();
		dstSeatIndex = this.readUInt8();
	}
}
