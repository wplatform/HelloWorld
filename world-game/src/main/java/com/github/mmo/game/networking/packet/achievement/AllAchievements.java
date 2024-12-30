package com.github.mmo.game.networking.packet.achievement;

import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


public class AllAchievements {
    public ArrayList<earnedAchievement> earned = new ArrayList<>();
    public ArrayList<CriteriaprogressPkt> progress = new ArrayList<>();

    public final void write(WorldPacket data) {
        data.writeInt32(earned.size());
        data.writeInt32(progress.size());

        for (var earned : earned) {
            earned.write(data);
        }

        for (var progress : progress) {
            progress.write(data);
        }
    }
}
