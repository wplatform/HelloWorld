package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class RequestCategoryCooldowns extends ClientPacket {
    public RequestCategoryCooldowns(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
