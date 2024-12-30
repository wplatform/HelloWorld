package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CalendarComplain extends ClientPacket {
    private ObjectGuid invitedByGUID = ObjectGuid.EMPTY;
    private long inviteID;
    private long eventID;

    public CalendarComplain(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        invitedByGUID = this.readPackedGuid();
        eventID = this.readUInt64();
        inviteID = this.readUInt64();
    }
}
