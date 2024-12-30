package com.github.mmo.game.networking.packet.misc;


public class SetAnimTier extends ServerPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;
    public int tier;

    public setAnimTier() {
        super(ServerOpcode.SetAnimTier, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(unit);
        this.writeBits(tier, 3);
        this.flushBits();
    }
}
