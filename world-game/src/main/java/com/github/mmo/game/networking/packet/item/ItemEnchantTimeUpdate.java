package com.github.mmo.game.networking.packet.item;


import com.github.mmo.game.networking.ServerPacket;

public class ItemEnchantTimeUpdate extends ServerPacket {
    public ObjectGuid ownerGuid = ObjectGuid.EMPTY;
    public ObjectGuid itemGuid = ObjectGuid.EMPTY;

    public int durationLeft;

    public int slot;

    public ItemEnchantTimeUpdate() {
        super(ServerOpcode.ItemEnchantTimeUpdate, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(itemGuid);
        this.writeInt32(durationLeft);
        this.writeInt32(slot);
        this.writeGuid(ownerGuid);
    }
}
