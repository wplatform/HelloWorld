package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class MovementAckMessage extends ClientPacket {
    public Movementack ack = new movementAck();

    public MovementAckMessage(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        ack.read(this);
    }
}
