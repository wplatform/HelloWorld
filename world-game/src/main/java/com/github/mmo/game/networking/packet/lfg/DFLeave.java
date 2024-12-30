package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class DFLeave extends ClientPacket {
    public Rideticket ticket = new rideTicket();

    public DFLeave(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        ticket.read(this);
    }
}
