package com.github.mmo.game.networking.packet.achievement;


import java.util.ArrayList;


public class AllGuildAchievements extends ServerPacket {
    public ArrayList<earnedAchievement> earned = new ArrayList<>();

    public AllGuildAchievements() {
        super(ServerOpcode.AllGuildAchievements);
    }

    @Override
    public void write() {
        this.writeInt32(earned.size());

        for (var earned : earned) {
            earned.write(this);
        }
    }
}
