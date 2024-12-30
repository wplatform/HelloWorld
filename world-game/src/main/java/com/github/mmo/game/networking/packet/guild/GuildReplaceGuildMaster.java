package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class GuildReplaceGuildMaster extends ClientPacket {
    public GuildReplaceGuildMaster(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
