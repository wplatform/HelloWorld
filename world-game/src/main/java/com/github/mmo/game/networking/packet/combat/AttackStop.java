package com.github.mmo.game.networking.packet.combat;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AttackStop extends ClientPacket {
    public attackStop(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
