package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.movement.model.MovementInfo;
import com.github.mmo.game.networking.WorldPacket;

public final class MovementAck
{
	public void read(WorldPacket data)
	{
		status = MovementIOUtil.readMovementInfo(data);
        ackIndex = data.readInt32();
	}

	public MovementInfo status;
	public int ackIndex;

	public MovementAck clone()
	{
		MovementAck varCopy = new movementAck();

		varCopy.status = this.status;
		varCopy.ackIndex = this.ackIndex;

		return varCopy;
	}
}
