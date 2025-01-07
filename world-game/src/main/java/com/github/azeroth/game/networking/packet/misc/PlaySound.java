package com.github.azeroth.game.networking.packet.misc;

import com.github.azeroth.game.networking.ServerPacket;

public class PlaySound extends ServerPacket {
    public ObjectGuid sourceObjectGuid = ObjectGuid.EMPTY;
    public int soundKitID;
    public int broadcastTextID;

    public playSound(ObjectGuid sourceObjectGuid, int soundKitID, int broadcastTextId) {
        super(ServerOpcode.playSound);
        sourceObjectGuid = sourceObjectGUID;
        soundKitID = soundKitID;
        broadcastTextID = broadcastTextId;
    }

    @Override
    public void write() {
        this.writeInt32(soundKitID);
        this.writeGuid(sourceObjectGUID);
        this.writeInt32(broadcastTextID);
    }
}
