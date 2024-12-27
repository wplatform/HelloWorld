package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class GuildDelete extends ClientPacket {
    public GuildDelete(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
