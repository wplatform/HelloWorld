package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ServerPacket;

public class DailyQuestsReset extends ServerPacket {
    public int count;

    public DailyQuestsReset() {
        super(ServerOpcode.DailyQuestsReset);
    }

    @Override
    public void write() {
        this.writeInt32(count);
    }
}
