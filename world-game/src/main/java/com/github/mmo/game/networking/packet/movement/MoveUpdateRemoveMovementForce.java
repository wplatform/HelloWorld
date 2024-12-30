package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.ServerPacket;

public class MoveUpdateRemoveMovementForce extends ServerPacket {
    public movementInfo status = new movementInfo();
    public ObjectGuid triggerGUID = ObjectGuid.EMPTY;

    public MoveUpdateRemoveMovementForce() {
        super(ServerOpcode.MoveUpdateRemoveMovementForce);
    }

    @Override
    public void write() {
        MovementIOUtil.writeMovementInfo(this, status);
        this.writeGuid(triggerGUID);
    }
}
