package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CalendarGetCalendar extends ClientPacket {
    public CalendarGetCalendar(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}

//Structs

