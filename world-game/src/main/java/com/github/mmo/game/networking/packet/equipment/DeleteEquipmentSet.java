package com.github.mmo.game.networking.packet.equipment;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class DeleteEquipmentSet extends ClientPacket {
    public long ID;

    public deleteEquipmentSet(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        ID = this.readUInt64();
    }
}
