package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;
public class MovementSpeedAck extends ClientPacket
{
	public Movementack ack = new movementAck();
	public float speed;
	public MovementSpeedAck(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		ack.read(this);
		speed = this.readFloat();
	}
}
