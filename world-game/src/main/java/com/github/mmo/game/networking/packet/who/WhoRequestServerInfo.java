package com.github.mmo.game.networking.packet.who;

import com.github.mmo.game.networking.*;
public final class WhoRequestServerInfo
{
	public void read(WorldPacket data)
	{
        factionGroup = data.readInt32();
        locale = data.readInt32();
        requesterVirtualRealmAddress = data.readUInt();
	}

	public int factionGroup;
	public int locale;
	public int requesterVirtualRealmAddress;

	public WhoRequestServerInfo clone()
	{
		WhoRequestServerInfo varCopy = new WhoRequestServerInfo();

		varCopy.factionGroup = this.factionGroup;
		varCopy.locale = this.locale;
		varCopy.requesterVirtualRealmAddress = this.requesterVirtualRealmAddress;

		return varCopy;
	}
}