package com.github.mmo.game.entity.item;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ItemMod
{
	public int value;
	public byte type;

	public final void writeCreate(WorldPacket data, Item owner, Player receiver)
	{
        data.writeInt32(value);
		data.writeInt8(type);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Item owner, Player receiver)
	{
        data.writeInt32(value);
		data.writeInt8(type);
	}
}