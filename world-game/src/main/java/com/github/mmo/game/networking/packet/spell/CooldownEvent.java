package com.github.mmo.game.networking.packet.spell;


public class CooldownEvent extends ServerPacket {
    public boolean isPet;

    public int spellID;


    public CooldownEvent(boolean isPet, int spellId) {
        super(ServerOpcode.CooldownEvent, ConnectionType.instance);
        isPet = isPet;
        spellID = spellId;
    }

    @Override
    public void write() {
        this.writeInt32(spellID);
        this.writeBit(isPet);
        this.flushBits();
    }
}
