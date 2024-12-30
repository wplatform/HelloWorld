package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CalendarUpdateEvent extends ClientPacket {
    public int maxSize;
    public CalendarUpdateeventInfo eventInfo = new calendarUpdateEventInfo();

    public CalendarUpdateEvent(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        eventInfo.read(this);
        maxSize = this.readUInt();
    }
}
