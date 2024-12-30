package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CalendarEventSignUp extends ClientPacket {
    public boolean tentative;
    public long eventID;
    public long clubID;

    public CalendarEventSignUp(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        eventID = this.readUInt64();
        clubID = this.readUInt64();
        tentative = this.readBit();
    }
}
