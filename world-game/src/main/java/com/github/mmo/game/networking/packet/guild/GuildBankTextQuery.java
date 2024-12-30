package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildBankTextQuery extends ClientPacket {
    public int tab;

    public GuildBankTextQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        tab = this.readInt32();
    }
}
