package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;public class MovementAckMessage extends ClientPacket {
    public Movementack ack = new movementAck();

    public MovementAckMessage(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        ack.read(this);
    }
}
