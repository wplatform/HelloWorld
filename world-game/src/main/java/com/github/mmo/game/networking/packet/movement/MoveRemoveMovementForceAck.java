package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;

class MoveRemoveMovementForceAck extends ClientPacket
{
	public Movementack ack = new movementAck();
    public ObjectGuid ID = ObjectGuid.EMPTY;
	public MoveRemoveMovementForceAck(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		ack.read(this);
        ID = this.readPackedGuid();
	}
}
