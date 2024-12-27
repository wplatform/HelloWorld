package com.github.mmo.game.networking.packet.loot;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class MasterLootCandidateList extends ServerPacket
{
	public ArrayList<ObjectGuid> players = new ArrayList<>();
	public ObjectGuid lootObj = ObjectGuid.EMPTY;
	public MasterLootCandidateList()
	{
		super(ServerOpcode.MasterLootCandidateList, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(lootObj);
		this.writeInt32(players.size());
		players.forEach(guid -> this.writeGuid(guid));
	}
}
