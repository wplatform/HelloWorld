package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

import java.util.ArrayList;

public class WorldQuestUpdateResponse extends ServerPacket {
    private final ArrayList<WorldQuestUpdateInfo> worldQuestUpdates = new ArrayList<>();

    public WorldQuestUpdateResponse() {
        super(ServerOpCode.WorldQuestUpdateResponse);
    }

    @Override
    public void write() {
        this.writeInt32(worldQuestUpdates.size());

        for (var worldQuestUpdate : worldQuestUpdates) {
            this.writeInt64(worldQuestUpdate.lastUpdate);
            this.writeInt32(worldQuestUpdate.questID);
            this.writeInt32(worldQuestUpdate.timer);
            this.writeInt32(worldQuestUpdate.variableID);
            this.writeInt32(worldQuestUpdate.value);
        }
    }
}
