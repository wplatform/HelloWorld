package com.github.mmo.game.networking.packet.achievement;

import com.github.mmo.game.networking.*;public class GuildSetFocusedAchievement extends ClientPacket {

    public int achievementID;

    public GuildSetFocusedAchievement(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        achievementID = this.readUInt();
    }
}
