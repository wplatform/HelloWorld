package com.github.mmo.game.networking.packet.guild;


import java.util.*;


public class GuildRosterUpdate extends ServerPacket
{
	public ArrayList<GuildRostermemberData> memberData;

	public GuildRosterUpdate()
	{
		super(ServerOpcode.GuildRosterUpdate);
		memberData = new ArrayList<>();
	}

	@Override
	public void write()
	{
		this.writeInt32(memberData.size());

		memberData.forEach(p -> p.write(this));
	}
}
