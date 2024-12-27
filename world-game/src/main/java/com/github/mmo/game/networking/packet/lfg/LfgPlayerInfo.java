package com.github.mmo.game.networking.packet.lfg;


import com.github.mmo.game.networking.*;

import java.util.*;class LfgPlayerInfo extends ServerPacket {
    public LFGblackList blackList = new LFGBlackList();
    public ArrayList<LfgPlayerDungeonInfo> dungeons = new ArrayList<>();

    public LfgPlayerInfo() {
        super(ServerOpcode.LfgPlayerInfo, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(dungeons.size());
        blackList.write(this);

        for (var dungeonInfo : dungeons) {
            dungeonInfo.write(this);
        }
    }
}
