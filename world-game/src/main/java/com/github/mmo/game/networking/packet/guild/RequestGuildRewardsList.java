package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class RequestGuildRewardsList extends ClientPacket {
    public long currentVersion;

    public RequestGuildRewardsList(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        currentVersion = this.readInt64();
    }
}
