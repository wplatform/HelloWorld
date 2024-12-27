package com.github.mmo.game.networking.packet.garrison;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class GarrisonRemoteInfo extends ServerPacket
{
	public ArrayList<GarrisonRemoteSiteInfo> sites = new ArrayList<>();
	public GarrisonRemoteInfo()
	{
		super(ServerOpcode.GarrisonRemoteInfo, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(sites.size());

		for (var site : sites)
		{
			site.write(this);
		}
	}
}
