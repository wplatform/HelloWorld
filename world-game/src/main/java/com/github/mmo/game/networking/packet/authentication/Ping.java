package com.github.mmo.game.networking.packet.authentication;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class Ping extends ClientPacket {
    public int serial;
    public int latency;

    public Ping(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        serial = this.readUInt();
        latency = this.readUInt();
    }
}

//Structs

