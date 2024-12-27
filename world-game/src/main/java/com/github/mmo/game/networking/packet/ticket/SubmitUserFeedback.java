package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.*;
public class SubmitUserFeedback extends ClientPacket
{
	public SupportTicketheader header = new supportTicketHeader();
	public String note;
	public boolean isSuggestion;

	public SubmitUserFeedback(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		header.read(this);
		var noteLength = this.<Integer>readBit(24);
		isSuggestion = this.readBit();

		if (noteLength != 0)
		{
			note = this.readString(noteLength - 1);
		}
	}
}
