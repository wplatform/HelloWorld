package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildQueryNews extends ClientPacket {
    public ObjectGuid guildGUID = ObjectGuid.EMPTY;

    public GuildQueryNews(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guildGUID = this.readPackedGuid();
    }
}
