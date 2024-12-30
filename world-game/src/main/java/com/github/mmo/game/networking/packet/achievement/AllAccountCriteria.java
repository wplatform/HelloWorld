package com.github.mmo.game.networking.packet.achievement;


import com.github.mmo.game.networking.ServerPacket;

import java.util.ArrayList;

public class AllAccountCriteria extends ServerPacket {
    public ArrayList<CriteriaprogressPkt> progress = new ArrayList<>();

    public AllAccountCriteria() {
        super(ServerOpcode.AllAccountCriteria, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(progress.size());

        for (var progress : progress) {
            progress.write(this);
        }
    }
}
