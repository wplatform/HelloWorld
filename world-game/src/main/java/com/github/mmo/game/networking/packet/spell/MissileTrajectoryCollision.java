package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.WorldPacket;

class MissileTrajectoryCollision extends ClientPacket
{
    public ObjectGuid target = ObjectGuid.EMPTY;
	public int spellID;
    public ObjectGuid castID = ObjectGuid.EMPTY;
	public Vector3 collisionPos;
	public MissileTrajectoryCollision(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        target = this.readPackedGuid();
        spellID = this.readUInt();
        castID = this.readPackedGuid();
        collisionPos = this.readVector3();
	}
}
