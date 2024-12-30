package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class DeclineGuildInvites extends ClientPacket {
    public boolean allow;

    public DeclineGuildInvites(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        allow = this.readBit();
    }
}
