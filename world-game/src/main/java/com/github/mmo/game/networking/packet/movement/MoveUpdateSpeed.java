package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.movement.model.MovementInfo;

public class MoveUpdateSpeed extends ServerPacket
{
	public MovementInfo status;
	public float speed = 1.0f;
	public MoveUpdateSpeed(ServerOpCode opcode)
	{
		super(opcode, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		MovementIOUtil.writeMovementInfo(this, status);
		this.writeFloat(speed);
	}
}
