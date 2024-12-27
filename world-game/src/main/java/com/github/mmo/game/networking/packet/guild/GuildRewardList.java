package com.github.mmo.game.networking.packet.guild;


import java.util.*;


public class GuildRewardList extends ServerPacket
{
	public ArrayList<GuildRewardItem> rewardItems;
	public long version;

	public GuildRewardList()
	{
		super(ServerOpcode.GuildRewardList);
		rewardItems = new ArrayList<>();
	}

	@Override
	public void write()
	{
        this.writeInt64(version);
        this.writeInt32(rewardItems.size());

		for (var item : rewardItems)
		{
			item.write(this);
		}
	}
}
