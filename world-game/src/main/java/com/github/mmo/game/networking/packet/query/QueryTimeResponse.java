package com.github.mmo.game.networking.packet.query;


public class QueryTimeResponse extends ServerPacket
{
	public long currentTime;
	public QueryTimeResponse()
	{
		super(ServerOpcode.QueryTimeResponse, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt64(currentTime);
	}
}
