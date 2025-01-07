package com.github.azeroth.game.networking.packet.update;


public class UpdateObject extends ServerPacket {
    public int numObjUpdates;
    public short mapID;
    public byte[] data;

    public UpdateObject() {
        super(ServerOpcode.UpdateObject);
    }

    @Override
    public void write() {
        this.writeInt32(numObjUpdates);
        this.writeInt16(mapID);
        this.writeBytes(data);
    }
}
