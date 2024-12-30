package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ServerPacket;

public class LootRemoved extends ServerPacket {
    public ObjectGuid lootObj = ObjectGuid.EMPTY;
    public ObjectGuid owner = ObjectGuid.EMPTY;
    public byte lootListID;

    public LootRemoved() {
        super(ServerOpcode.LootRemoved, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(owner);
        this.writeGuid(lootObj);
        this.writeInt8(lootListID);
    }
}
