package com.github.mmo.game.networking.packet.who;

import com.github.mmo.game.networking.*;
import java.util.*;


public class WhoRequestPkt extends ClientPacket
{
	public Whorequest request = new whoRequest();
	public int requestID;
	public ArrayList<Integer> areas = new ArrayList<>();
	public WhoRequestPkt(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        var areasCount = this.<Integer>readBit(4);

		request.read(this);
        requestID = this.readUInt();

		for (var i = 0; i < areasCount; ++i)
		{
            areas.add(this.readInt32());
		}
	}
}