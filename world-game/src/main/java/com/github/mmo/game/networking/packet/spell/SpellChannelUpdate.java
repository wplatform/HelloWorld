package com.github.mmo.game.networking.packet.spell;


public class SpellChannelUpdate extends ServerPacket {
    public ObjectGuid casterGUID = ObjectGuid.EMPTY;
    public int timeRemaining;

    public SpellChannelUpdate() {
        super(ServerOpcode.SpellChannelUpdate, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(casterGUID);
        this.writeInt32(timeRemaining);
    }
}
