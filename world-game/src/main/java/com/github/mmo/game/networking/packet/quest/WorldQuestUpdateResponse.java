package com.github.mmo.game.networking.packet.quest;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class WorldQuestUpdateResponse extends ServerPacket
{
	private final ArrayList<WorldQuestUpdateInfo> worldQuestUpdates = new ArrayList<>();
	public WorldQuestUpdateResponse()
	{
		super(ServerOpcode.WorldQuestUpdateResponse, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(worldQuestUpdates.size());

		for (var worldQuestUpdate : worldQuestUpdates)
		{
            this.writeInt64(worldQuestUpdate.lastUpdate);
            this.writeInt32(worldQuestUpdate.questID);
            this.writeInt32(worldQuestUpdate.timer);
            this.writeInt32(worldQuestUpdate.variableID);
            this.writeInt32(worldQuestUpdate.value);
		}
	}
}