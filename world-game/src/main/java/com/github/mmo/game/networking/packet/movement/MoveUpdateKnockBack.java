package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.movement.model.MovementInfo;

public class MoveUpdateKnockBack extends ServerPacket {
    public MovementInfo status;

    public MoveUpdateKnockBack() {
        super(ServerOpcode.MoveUpdateKnockBack);
    }

    @Override
    public void write() {
        MovementIOUtil.writeMovementInfo(this, status);
    }
}
