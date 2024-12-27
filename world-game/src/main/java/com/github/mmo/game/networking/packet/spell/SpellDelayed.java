package com.github.mmo.game.networking.packet.spell;


import com.github.mmo.game.networking.*;public class SpellDelayed extends ServerPacket {
    public ObjectGuid caster = ObjectGuid.EMPTY;
    public int actualDelay;

    public SpellDelayed() {
        super(ServerOpcode.SpellDelayed, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(caster);
        this.writeInt32(actualDelay);
    }
}
