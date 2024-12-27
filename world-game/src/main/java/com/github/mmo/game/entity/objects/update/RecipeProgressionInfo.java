package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class RecipeProgressionInfo
{
	public short recipeProgressionGroupID;
	public short experience;

	public final void writeCreate(WorldPacket data, Player owner, Player receiver)
	{
		data.writeInt16(recipeProgressionGroupID);
		data.writeInt16(experience);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver)
	{
		data.writeInt16(recipeProgressionGroupID);
		data.writeInt16(experience);
	}
}
