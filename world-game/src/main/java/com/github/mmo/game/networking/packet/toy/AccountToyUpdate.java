package com.github.mmo.game.networking.packet.toy;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class AccountToyUpdate extends ServerPacket
{
	public boolean isFullUpdate = false;
	public HashMap<Integer, toyFlags> toys = new HashMap<Integer, toyFlags>();
	public AccountToyUpdate()
	{
		super(ServerOpcode.AccountToyUpdate, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeBit(isFullUpdate);
		this.flushBits();

		// all lists have to have the same size
		this.writeInt32(toys.size());
		this.writeInt32(toys.size());
		this.writeInt32(toys.size());

		for (var pair : toys.entrySet())
		{
			this.writeInt32(pair.getKey());
		}

		for (var pair : toys.entrySet())
		{
			this.writeBit(pair.getValue().HasAnyFlag(toyFlags.favorite));
		}

		for (var pair : toys.entrySet())
		{
			this.writeBit(pair.getValue().HasAnyFlag(toyFlags.HasFanfare));
		}

		this.flushBits();
	}
}