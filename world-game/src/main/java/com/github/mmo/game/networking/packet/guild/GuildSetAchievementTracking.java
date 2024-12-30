package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


class GuildSetAchievementTracking extends ClientPacket {
    public ArrayList<Integer> achievementIDs = new ArrayList<>();

    public GuildSetAchievementTracking(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var count = this.readUInt();

        for (int i = 0; i < count; ++i) {
            achievementIDs.add(this.readUInt());
        }
    }
}
