package com.github.mmo.game.entity.player.model;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class SpellFlatModByLabel
{
	public int modIndex;
	public int modifierValue;
	public int labelID;

	public final void writeCreate(WorldPacket data, Player owner, Player receiver)
	{
		data.writeInt32(modIndex);
		data.writeInt32(modifierValue);
		data.writeInt32(labelID);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver)
	{
		data.writeInt32(modIndex);
		data.writeInt32(modifierValue);
		data.writeInt32(labelID);
	}
}
