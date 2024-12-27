package com.github.mmo.game.networking.packet.battlenet;
import com.github.mmo.game.networking.ServerPacket;
public class ChangeRealmTicketResponse extends ServerPacket
{
	public int token;
	public boolean allow = true;
	public ByteBuffer ticket;
	public ChangeRealmTicketResponse()
	{
		super(ServerOpcode.ChangeRealmTicketResponse);
	}

	@Override
	public void write()
	{
		this.writeInt32(token);
		this.writeBit(allow);
		this.writeInt32(ticket.getSize());
		this.writeBytes(ticket);
	}
}
