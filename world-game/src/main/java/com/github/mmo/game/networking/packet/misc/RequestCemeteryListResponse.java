package com.github.mmo.game.networking.packet.misc;


import java.util.*;


public class RequestCemeteryListResponse extends ServerPacket
{
	public boolean isGossipTriggered;
	public ArrayList<Integer> cemeteryID = new ArrayList<>();
	public RequestCemeteryListResponse()
	{
		super(ServerOpcode.RequestCemeteryListResponse, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeBit(isGossipTriggered);
		this.flushBits();

		this.writeInt32(cemeteryID.size());

		for (var cemetery : cemeteryID)
		{
			this.writeInt32(cemetery);
		}
	}
}
