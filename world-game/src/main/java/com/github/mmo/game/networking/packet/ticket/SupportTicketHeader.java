package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.*;

public final class SupportTicketHeader
{
	public void read(WorldPacket packet)
	{
		mapID = packet.readUInt();
		position = packet.readVector3();
		facing = packet.readFloat();
		program = packet.readInt32();
	}

	public int mapID;
	public Vector3 position;
	public float facing;
	public int program;

	public SupportTicketHeader clone()
	{
		SupportTicketHeader varCopy = new supportTicketHeader();

		varCopy.mapID = this.mapID;
		varCopy.position = this.position;
		varCopy.facing = this.facing;
		varCopy.program = this.program;

		return varCopy;
	}
}
