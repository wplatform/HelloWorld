package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class AutoEquipItemSlot extends ClientPacket {
    public ObjectGuid item = ObjectGuid.EMPTY;

    public byte itemDstSlot;
    public invUpdate inv = new invUpdate();

    public AutoEquipItemSlot(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        inv = new invUpdate(this);
        item = this.readPackedGuid();
        itemDstSlot = this.readUInt8();
    }
}
