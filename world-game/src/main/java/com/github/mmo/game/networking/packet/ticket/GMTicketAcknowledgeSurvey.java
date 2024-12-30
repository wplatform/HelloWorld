package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GMTicketAcknowledgeSurvey extends ClientPacket {
    private int caseID;

    public GMTicketAcknowledgeSurvey(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        caseID = this.readInt32();
    }
}
