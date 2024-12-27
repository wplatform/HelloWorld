package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
import java.util.*;


public class GuildRewardItem
{
	public int itemID;
	public int unk4;
	public ArrayList<Integer> achievementsRequired = new ArrayList<>();
	public long raceMask;
	public int minGuildLevel;
	public int minGuildRep;
	public long cost;

	public final void write(WorldPacket data)
	{
		data.writeInt32(itemID);
		data.writeInt32(unk4);
		data.writeInt32(achievementsRequired.size());
		data.writeInt64(raceMask);
		data.writeInt32(minGuildLevel);
		data.writeInt32(minGuildRep);
		data.writeInt64(cost);

		for (var achievementId : achievementsRequired)
		{
			data.writeInt32(achievementId);
		}
	}
}
