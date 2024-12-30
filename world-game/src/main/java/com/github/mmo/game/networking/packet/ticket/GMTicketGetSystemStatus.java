package com.github.mmo.game.networking.packet.ticket;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GMTicketGetSystemStatus extends ClientPacket {
    public GMTicketGetSystemStatus(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}

//Structs

