package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildDeleteRank extends ClientPacket {
    public int rankOrder;

    public GuildDeleteRank(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        rankOrder = this.readInt32();
    }
}
