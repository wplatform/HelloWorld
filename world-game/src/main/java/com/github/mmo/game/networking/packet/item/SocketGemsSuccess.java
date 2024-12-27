package com.github.mmo.game.networking.packet.item;
import com.github.mmo.game.networking.ServerPacket;
public class SocketGemsSuccess extends ServerPacket
{
    public ObjectGuid item = ObjectGuid.EMPTY;
	public SocketGemsSuccess()
	{
		super(ServerOpcode.SocketGemsSuccess, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeGuid(item);
	}
}
