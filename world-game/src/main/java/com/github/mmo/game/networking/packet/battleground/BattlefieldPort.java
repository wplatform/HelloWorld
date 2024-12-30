package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BattlefieldPort extends ClientPacket {
    public Rideticket ticket = new rideTicket();
    public boolean acceptedInvite;

    public BattlefieldPort(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        ticket.read(this);
        acceptedInvite = this.readBit();
    }
}
