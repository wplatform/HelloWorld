package com.github.mmo.game.networking.packet.mythicplus;

import com.github.mmo.game.networking.*;
import java.util.*;


public class DungeonScoreMapData
{
	public int mapChallengeModeID;
	public ArrayList<DungeonScoreBestRunForAffix> bestRuns = new ArrayList<>();
	public float overAllScore;

	public final void write(WorldPacket data)
	{
		data.writeInt32(mapChallengeModeID);
		data.writeInt32(bestRuns.size());
		data.writeFloat(overAllScore);

		for (var bestRun : bestRuns)
		{
			bestRun.write(data);
		}
	}
}
