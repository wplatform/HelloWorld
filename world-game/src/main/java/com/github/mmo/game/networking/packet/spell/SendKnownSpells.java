package com.github.mmo.game.networking.packet.spell;


import java.util.*;


public class SendKnownSpells extends ServerPacket
{
	public boolean initialLogin;
	public ArrayList<Integer> knownSpells = new ArrayList<>();
	public ArrayList<Integer> favoriteSpells = new ArrayList<>(); // tradeskill recipes
	public sendKnownSpells()
	{
		super(ServerOpcode.SendKnownSpells, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeBit(initialLogin);
        this.writeInt32(knownSpells.size());
        this.writeInt32(favoriteSpells.size());

		for (var spellId : knownSpells)
		{
            this.writeInt32(spellId);
		}

		for (var spellId : favoriteSpells)
		{
            this.writeInt32(spellId);
		}
	}
}
