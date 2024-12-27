package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class GuildChallengeUpdateRequest extends ClientPacket {
    public GuildChallengeUpdateRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
