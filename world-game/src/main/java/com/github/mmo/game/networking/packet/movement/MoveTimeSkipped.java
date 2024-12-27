package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;

class MoveTimeSkipped extends ClientPacket
{
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;
	public int timeSkipped;
	public MoveTimeSkipped(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        moverGUID = this.readPackedGuid();
        timeSkipped = this.readUInt();
	}
}
