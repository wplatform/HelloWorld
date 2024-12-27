package com.github.mmo.game.networking.packet.chat;


import com.github.mmo.game.networking.*;

import java.util.*;public class EmoteMessage extends ServerPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public int emoteID;

    public ArrayList<Integer> spellVisualKitIDs = new ArrayList<>();
    public int sequenceVariation;

    public EmoteMessage() {
        super(ServerOpcode.emote, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(guid);
        this.writeInt32(emoteID);
        this.writeInt32(spellVisualKitIDs.size());
        this.writeInt32(sequenceVariation);

        for (var id : spellVisualKitIDs) {
            this.writeInt32(id);
        }
    }
}
