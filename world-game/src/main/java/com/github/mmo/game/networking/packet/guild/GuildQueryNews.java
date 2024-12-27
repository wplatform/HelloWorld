package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class GuildQueryNews extends ClientPacket {
    public ObjectGuid guildGUID = ObjectGuid.EMPTY;

    public GuildQueryNews(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guildGUID = this.readPackedGuid();
    }
}
