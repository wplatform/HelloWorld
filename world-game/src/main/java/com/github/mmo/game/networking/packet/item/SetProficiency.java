package com.github.mmo.game.networking.packet.item;


public class SetProficiency extends ServerPacket {
    public int proficiencyMask;
    public byte proficiencyClass;

    public SetProficiency() {
        super(ServerOpcode.SetProficiency, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(proficiencyMask);
        this.writeInt8(proficiencyClass);
    }
}
