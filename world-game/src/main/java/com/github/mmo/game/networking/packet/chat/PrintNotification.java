package com.github.mmo.game.networking.packet.chat;


public class PrintNotification extends ServerPacket
{
	public String notifyText;

	public PrintNotification(String notifyText)
	{
		super(ServerOpcode.PrintNotification);
		notifyText = notifyText;
	}

	@Override
	public void write()
	{
		this.writeBits(notifyText.GetByteCount(), 12);
		this.writeString(notifyText);
	}
}
