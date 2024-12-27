package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.WorldPacket;
public final class MissileTrajectoryResult
{
	public int travelTime;
	public float pitch;

	public void write(WorldPacket data)
	{
        data.writeInt32(travelTime);
        data.writeFloat(pitch);
	}

	public MissileTrajectoryResult clone()
	{
		MissileTrajectoryResult varCopy = new missileTrajectoryResult();

		varCopy.travelTime = this.travelTime;
		varCopy.pitch = this.pitch;

		return varCopy;
	}
}
