package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GMTicketGetCaseStatus extends ClientPacket {
    public GMTicketGetCaseStatus(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
