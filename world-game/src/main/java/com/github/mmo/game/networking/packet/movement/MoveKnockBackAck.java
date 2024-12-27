package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;
class MoveKnockBackAck extends ClientPacket
{
	public Movementack ack = new movementAck();
	public MoveKnockBackspeeds speeds = null;
	public MoveKnockBackAck(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		ack.read(this);

        if (this.readBit())
		{
			speeds = new moveKnockBackSpeeds();
			speeds.getValue().read(this);
		}
	}
}
