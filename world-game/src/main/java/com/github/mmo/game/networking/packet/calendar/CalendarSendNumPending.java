package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.ServerPacket;

public class CalendarSendNumPending extends ServerPacket {
    public int numPending;

    public CalendarSendNumPending(int numPending) {
        super(ServerOpcode.CalendarSendNumPending);
        numPending = numPending;
    }

    @Override
    public void write() {
        this.writeInt32(numPending);
    }
}
