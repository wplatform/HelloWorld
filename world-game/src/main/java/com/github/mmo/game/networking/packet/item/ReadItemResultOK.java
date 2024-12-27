package com.github.mmo.game.networking.packet.item;
import com.github.mmo.game.networking.ServerPacket;
public class ReadItemResultOK extends ServerPacket
{
	public ObjectGuid item = ObjectGuid.EMPTY;
	public ReadItemResultOK()
	{
		super(ServerOpcode.ReadItemResultOk);
	}

	@Override
	public void write()
	{
		this.writeGuid(item);
	}
}
