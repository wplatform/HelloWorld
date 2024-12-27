package com.github.mmo.game.networking.packet.mythicplus;

import com.github.mmo.game.networking.*;
import java.util.*;


public class DungeonScoreData
{
	public ArrayList<DungeonScoreSeasonData> seasons = new ArrayList<>();
	public int totalRuns;

	public final void write(WorldPacket data)
	{
		data.writeInt32(seasons.size());
		data.writeInt32(totalRuns);

		for (var season : seasons)
		{
			season.write(data);
		}
	}
}
