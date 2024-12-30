package com.github.mmo.game.networking.packet.totem;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class TotemDestroyed extends ClientPacket {
    public ObjectGuid totemGUID = ObjectGuid.EMPTY;
    public byte slot;

    public TotemDestroyed(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        slot = this.readUInt8();
        totemGUID = this.readPackedGuid();
    }
}
