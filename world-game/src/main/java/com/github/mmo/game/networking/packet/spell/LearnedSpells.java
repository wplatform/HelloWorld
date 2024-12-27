package com.github.mmo.game.networking.packet.spell;


import java.util.*;


public class LearnedSpells extends ServerPacket
{
	public ArrayList<LearnedSpellInfo> clientLearnedSpellData = new ArrayList<>();
	public int specializationID;
	public boolean suppressMessaging;
	public LearnedSpells()
	{
		super(ServerOpcode.LearnedSpells, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(clientLearnedSpellData.size());
        this.writeInt32(specializationID);
        this.writeBit(suppressMessaging);
        this.flushBits();

		for (var spell : clientLearnedSpellData)
		{
			spell.write(this);
		}
	}
}
