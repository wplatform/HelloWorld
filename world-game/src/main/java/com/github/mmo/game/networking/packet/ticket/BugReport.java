package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.*;
class BugReport extends ClientPacket
{
	public int type;
	public String text;
	public String diagInfo;
	public BugReport(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        type = this.readBit();
        var diagLen = this.<Integer>readBit(12);
        var textLen = this.<Integer>readBit(10);
        diagInfo = this.readString(diagLen);
        text = this.readString(textLen);
	}
}
