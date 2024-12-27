package com.github.mmo.game.networking.packet.spell;


import java.util.*;


public class SendUnlearnSpells extends ServerPacket
{
	private final ArrayList<Integer> spells = new ArrayList<>();

	public sendUnlearnSpells()
	{
		super(ServerOpcode.SendUnlearnSpells, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(spells.size());

		for (var spell : spells)
		{
            this.writeInt32(spell);
		}
	}
}
