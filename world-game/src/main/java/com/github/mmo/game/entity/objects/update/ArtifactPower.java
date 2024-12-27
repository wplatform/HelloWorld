package com.github.mmo.game.entity;

import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ArtifactPower
{
	public short artifactPowerId;
	public byte purchasedRank;
	public byte currentRankWithBonus;

	public final void writeCreate(WorldPacket data, Item owner, Player receiver)
	{
		data.writeInt16(artifactPowerId);
		data.writeInt8(purchasedRank);
		data.writeInt8(currentRankWithBonus);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Item owner, Player receiver)
	{
		data.writeInt16(artifactPowerId);
		data.writeInt8(purchasedRank);
		data.writeInt8(currentRankWithBonus);
	}
}
