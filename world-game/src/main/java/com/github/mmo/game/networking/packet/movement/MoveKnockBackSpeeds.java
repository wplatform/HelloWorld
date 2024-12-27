package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;
public final class MoveKnockBackSpeeds
{
	public void write(WorldPacket data)
	{
		data.writeFloat(horzSpeed);
		data.writeFloat(vertSpeed);
	}

	public void read(WorldPacket data)
	{
		horzSpeed = data.readFloat();
		vertSpeed = data.readFloat();
	}

	public float horzSpeed;
	public float vertSpeed;

	public MoveKnockBackSpeeds clone()
	{
		MoveKnockBackSpeeds varCopy = new moveKnockBackSpeeds();

		varCopy.horzSpeed = this.horzSpeed;
		varCopy.vertSpeed = this.vertSpeed;

		return varCopy;
	}
}
