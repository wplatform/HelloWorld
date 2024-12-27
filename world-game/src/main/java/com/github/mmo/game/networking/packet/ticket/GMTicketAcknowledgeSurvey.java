package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.*;
public class GMTicketAcknowledgeSurvey extends ClientPacket
{
	private int caseID;
	public GMTicketAcknowledgeSurvey(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		caseID = this.readInt32();
	}
}
