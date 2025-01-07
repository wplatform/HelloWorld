package com.github.azeroth.game.networking.packet.misc;

import com.github.azeroth.game.networking.ServerPacket;

public class PlayObjectSound extends ServerPacket {
    public ObjectGuid targetObjectGUID = ObjectGuid.EMPTY;
    public ObjectGuid sourceObjectGUID = ObjectGuid.EMPTY;
    public int soundKitID;
    public Vector3 position;
    public int broadcastTextID;

    public PlayObjectSound() {
        super(ServerOpcode.PlayObjectSound);
    }

    @Override
    public void write() {
        this.writeInt32(soundKitID);
        this.writeGuid(sourceObjectGUID);
        this.writeGuid(targetObjectGUID);
        this.writeVector3(position);
        this.writeInt32(broadcastTextID);
    }
}
