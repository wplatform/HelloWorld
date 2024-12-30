package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class RequestVehicleExit extends ClientPacket {
    public RequestVehicleExit(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
