package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;
import java.util.*;


class PartyMemberAuraStates
{
	public int spellID;
	public short flags;
	public int activeFlags;
	public ArrayList<Float> points = new ArrayList<>();

	public final void write(WorldPacket data)
	{
        data.writeInt32(spellID);
		data.writeInt16(flags);
        data.writeInt32(activeFlags);
        data.writeInt32(points.size());

		for (var points : points)
		{
            data.writeFloat(points);
		}
	}
}
