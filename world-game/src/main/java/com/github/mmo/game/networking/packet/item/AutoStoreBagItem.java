package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AutoStoreBagItem extends ClientPacket {
    public byte containerSlotB;
    public invUpdate inv = new invUpdate();
    public byte containerSlotA;
    public byte slotA;

    public AutoStoreBagItem(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        inv = new invUpdate(this);
        containerSlotB = this.readUInt8();
        containerSlotA = this.readUInt8();
        slotA = this.readUInt8();
    }
}
