package com.github.mmo.game.networking.packet.instance;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class InstanceInfoPkt extends ServerPacket
{
	public ArrayList<InstanceLockPkt> lockList = new ArrayList<>();
	public InstanceInfoPkt()
	{
		super(ServerOpcode.InstanceInfo);
	}

	@Override
	public void write()
	{
		this.writeInt32(lockList.size());

		for (var lockInfos : lockList)
		{
			lockInfos.write(this);
		}
	}
}
