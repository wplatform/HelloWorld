package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class OverrideScreenFlash extends ClientPacket {
    public boolean screenFlashEnabled;

    public overrideScreenFlash(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        screenFlashEnabled = this.readBit() == 1;
    }
}
