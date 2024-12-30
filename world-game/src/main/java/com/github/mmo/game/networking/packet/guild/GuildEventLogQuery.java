package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildEventLogQuery extends ClientPacket {
    public GuildEventLogQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
