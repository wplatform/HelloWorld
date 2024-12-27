package com.github.mmo.game.networking.packet.voidstorage;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class VoidStorageContents extends ServerPacket
{
	public ArrayList<VoidItem> items = new ArrayList<>();
	public VoidStorageContents()
	{
		super(ServerOpcode.VoidStorageContents, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeBits(items.size(), 8);
		this.flushBits();

		for (var voidItem : items)
		{
			voidItem.write(this);
		}
	}
}
