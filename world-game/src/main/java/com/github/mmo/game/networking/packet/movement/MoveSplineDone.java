package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.movement.model.MovementInfo;
import com.github.mmo.game.networking.*;

class MoveSplineDone extends ClientPacket
{
	public MovementInfo status;
	public int splineID;
	public MoveSplineDone(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		status = MovementIOUtil.readMovementInfo(this);
		splineID = this.readInt32();
	}
}
