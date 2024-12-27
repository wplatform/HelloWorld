package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.movement.model.MovementInfo;

public class MoveUpdate extends ServerPacket
{
	public MovementInfo status;
	public moveUpdate()
	{
		super(ServerOpcode.moveUpdate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		MovementIOUtil.writeMovementInfo(this, status);
	}
}
