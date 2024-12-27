package com.github.mmo.game.networking.packet.reputation;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class SetFactionStanding extends ServerPacket
{
	public float bonusFromAchievementSystem;
	public ArrayList<factionStandingData> faction = new ArrayList<>();
	public boolean showVisual;
	public SetFactionStanding()
	{
		super(ServerOpcode.SetFactionStanding, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeFloat(bonusFromAchievementSystem);

		this.writeInt32(faction.size());

		for (var factionStanding : faction)
		{
			factionStanding.write(this);
		}

		this.writeBit(showVisual);
		this.flushBits();
	}
}
