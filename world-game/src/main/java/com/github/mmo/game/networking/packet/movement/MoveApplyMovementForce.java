package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.networking.ServerPacket;

public class MoveApplyMovementForce extends ServerPacket {
    public ObjectGuid moverGUID = ObjectGuid.EMPTY;
    public int sequenceIndex;
    public Movementforce force;

    public MoveApplyMovementForce() {
        super(ServerOpcode.MoveApplyMovementForce, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(moverGUID);
        this.writeInt32(sequenceIndex);
        force.write(this);
    }
}
