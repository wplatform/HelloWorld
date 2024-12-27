package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.movement.movementForce;
import com.github.mmo.game.networking.*;

class MoveApplyMovementForceAck extends ClientPacket
{
	public Movementack ack = new movementAck();
	public Movementforce force = new movementForce();
	public MoveApplyMovementForceAck(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		ack.read(this);
		force.read(this);
	}
}
