package com.github.mmo.game.networking.packet.warden;
import com.github.mmo.game.networking.ServerPacket;
public class Warden3DataServer extends ServerPacket
{
	public ByteBuffer data;
	public Warden3DataServer()
	{
		super(ServerOpcode.Warden3Data);
	}

	@Override
	public void write()
	{
        this.writeBytes(data);
	}
}
