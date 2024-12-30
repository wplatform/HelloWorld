package com.github.mmo.game.networking.packet.worldstate;


public class UpdateWorldState extends ServerPacket {
    public int value;
    public boolean hidden; // @todo: research
    public int variableID;

    public updateWorldState() {
        super(ServerOpcode.UpdateWorldState, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(variableID);
        this.writeInt32(value);
        this.writeBit(hidden);
        this.flushBits();
    }
}
