package com.github.mmo.game.networking.packet.calendar;
import com.github.mmo.game.networking.ServerPacket;
public class CalendarClearPendingAction extends ServerPacket
{
	public CalendarClearPendingAction()
	{
		super(ServerOpcode.CalendarClearPendingAction);
	}

	@Override
	public void write()
	{
	}
}
