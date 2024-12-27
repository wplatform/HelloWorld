package com.github.mmo.game;


import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;

public class QuestPOIData
{
	public int questID;
	public ArrayList<QuestPOIBlobData> blobs;

	public QuestPOIData(int questId)
	{
		questID = questId;
		blobs = new ArrayList<>();
	}

	public final void initializeQueryData()
	{

	}

	public final void write(WorldPacket data)
	{
        data.writeInt32(questID);
        data.writeInt32(blobs.size());

		for (var questPOIBlobData : blobs)
		{
            data.writeInt32(questPOIBlobData.blobIndex);
            data.writeInt32(questPOIBlobData.objectiveIndex);
            data.writeInt32(questPOIBlobData.questObjectiveID);
            data.writeInt32(questPOIBlobData.questObjectID);
            data.writeInt32(questPOIBlobData.mapID);
            data.writeInt32(questPOIBlobData.uiMapID);
            data.writeInt32(questPOIBlobData.priority);
            data.writeInt32(questPOIBlobData.flags);
            data.writeInt32(questPOIBlobData.worldEffectID);
            data.writeInt32(questPOIBlobData.playerConditionID);
            data.writeInt32(questPOIBlobData.navigationPlayerConditionID);
            data.writeInt32(questPOIBlobData.spawnTrackingID);
            data.writeInt32(questPOIBlobData.points.size());

			for (var questPOIBlobPoint : questPOIBlobData.points)
			{
                data.writeInt16((short) questPOIBlobPoint.X);
                data.writeInt16((short) questPOIBlobPoint.Y);
                data.writeInt16((short) questPOIBlobPoint.Z);
			}

            data.writeBit(questPOIBlobData.alwaysAllowMergingBlobs);
            data.flushBits();
		}
	}
}
