package com.github.mmo.game.networking.packet.misc;


public class TimeSyncRequest extends ServerPacket {
    public int sequenceIndex;

    public TimeSyncRequest() {
        super(ServerOpcode.TimeSyncRequest, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(sequenceIndex);
    }
}
