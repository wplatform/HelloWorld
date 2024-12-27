package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.networking.*;

public class UnitChannel
{
	public int spellID;
	public int spellXSpellVisualID;
	public spellCastVisualField spellVisual = new spellCastVisualField();

	public final void writeCreate(WorldPacket data, Unit owner, Player receiver)
	{
		data.writeInt32(spellID);
		spellVisual.writeCreate(data, owner, receiver);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Unit owner, Player receiver)
	{
		data.writeInt32(spellID);
		spellVisual.writeUpdate(data, ignoreChangesMask, owner, receiver);
	}
}
