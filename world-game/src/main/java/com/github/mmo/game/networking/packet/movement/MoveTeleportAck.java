package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class MoveTeleportAck extends ClientPacket {
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;
    private int ackIndex;
    private int moveTime;

    public MoveTeleportAck(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        moverGUID = this.readPackedGuid();
        ackIndex = this.readInt32();
        moveTime = this.readInt32();
    }
}
