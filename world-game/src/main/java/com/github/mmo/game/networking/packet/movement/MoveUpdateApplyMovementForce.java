package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.movement.movementForce;
import com.github.mmo.game.networking.ServerPacket;

public class MoveUpdateApplyMovementForce extends ServerPacket {
    public movementInfo status = new movementInfo();
    public Movementforce force = new movementForce();

    public MoveUpdateApplyMovementForce() {
        super(ServerOpcode.MoveUpdateApplyMovementForce);
    }

    @Override
    public void write() {
        MovementIOUtil.writeMovementInfo(this, status);
        force.write(this);
    }
}
