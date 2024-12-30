package com.github.mmo.game.networking.packet.battleground;


import com.github.mmo.game.networking.ServerPacket;

import java.util.ArrayList;

public class BattlegroundPlayerPositions extends ServerPacket {
    public ArrayList<BattlegroundPlayerPosition> flagCarriers = new ArrayList<>();

    public BattlegroundPlayerPositions() {
        super(ServerOpcode.BattlegroundPlayerPositions, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(flagCarriers.size());

        for (var pos : flagCarriers) {
            pos.write(this);
        }
    }
}
