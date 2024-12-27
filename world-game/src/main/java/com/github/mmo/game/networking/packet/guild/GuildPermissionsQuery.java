package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class GuildPermissionsQuery extends ClientPacket {
    public GuildPermissionsQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
