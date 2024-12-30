package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class SetSelection extends ClientPacket {
    public ObjectGuid selection = ObjectGuid.EMPTY; // Target

    public setSelection(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        selection = this.readPackedGuid();
    }
}
