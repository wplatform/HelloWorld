package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CalendarRemoveEvent extends ClientPacket {
    public long moderatorID;
    public long eventID;
    public long clubID;
    public int flags;

    public CalendarRemoveEvent(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        eventID = this.readUInt64();
        moderatorID = this.readUInt64();
        clubID = this.readUInt64();
        flags = this.readUInt();
    }
}
