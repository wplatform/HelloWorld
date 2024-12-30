package com.github.mmo.game.networking.packet.spell;


public class ClearAllSpellCharges extends ServerPacket {
    public boolean isPet;

    public ClearAllSpellCharges() {
        super(ServerOpcode.ClearAllSpellCharges, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeBit(isPet);
        this.flushBits();
    }
}
