package com.github.azeroth.game.networking.packet.misc;

import com.github.azeroth.game.networking.ServerPacket;

public class PlaySpeakerBoxSound extends ServerPacket {
    public ObjectGuid sourceObjectGUID = ObjectGuid.EMPTY;
    public int soundKitID;

    public PlaySpeakerBoxSound(ObjectGuid sourceObjectGuid, int soundKitID) {
        super(ServerOpcode.PlaySpeakerbotSound);
        sourceObjectGUID = sourceObjectGUID;
        soundKitID = soundKitID;
    }

    @Override
    public void write() {
        this.writeGuid(sourceObjectGUID);
        this.writeInt32(soundKitID);
    }
}
