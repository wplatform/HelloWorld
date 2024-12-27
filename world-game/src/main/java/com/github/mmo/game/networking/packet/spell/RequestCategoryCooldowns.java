package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;public class RequestCategoryCooldowns extends ClientPacket {
    public RequestCategoryCooldowns(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
