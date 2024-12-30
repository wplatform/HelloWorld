package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildLeave extends ClientPacket {
    public GuildLeave(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
