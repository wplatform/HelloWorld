package com.github.mmo.game.networking.packet.combat;


import java.util.*;


public class ThreatUpdate extends ServerPacket
{
	public ObjectGuid unitGUID = ObjectGuid.EMPTY;
	public ArrayList<ThreatInfo> threatList = new ArrayList<>();
	public ThreatUpdate()
	{
		super(ServerOpcode.ThreatUpdate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(unitGUID);
		this.writeInt32(threatList.size());

		for (var threatInfo : threatList)
		{
			this.writeGuid(threatInfo.unitGUID);
			this.writeInt64(threatInfo.threat);
		}
	}
}