package com.github.mmo.game.networking.packet.achievement;


public class AllAchievementData extends ServerPacket {
    public allAchievements data = new allAchievements();

    public AllAchievementData() {
        super(ServerOpcode.AllAchievementData, ConnectionType.instance);
    }

    @Override
    public void write() {
        data.write(this);
    }
}

//Structs

