package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ServerPacket;

public class CrossedInebriationThreshold extends ServerPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;
    public int itemID;
    public int threshold;

    public CrossedInebriationThreshold() {
        super(ServerOpcode.CrossedInebriationThreshold);
    }

    @Override
    public void write() {
        this.writeGuid(guid);
        this.writeInt32(threshold);
        this.writeInt32(itemID);
    }
}
