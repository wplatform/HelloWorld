package com.github.mmo.game.networking.packet.movement;


import com.github.mmo.game.movement.model.MovementInfo;
import com.github.mmo.game.networking.*;

public class MoveUpdateCollisionHeight extends ServerPacket {
    public MovementInfo status;
    public float scale = 1.0f;
    public float height = 1.0f;

    public MoveUpdateCollisionHeight() {
        super(ServerOpcode.MoveUpdateCollisionHeight);
    }

    @Override
    public void write() {
        MovementIOUtil.writeMovementInfo(this, status);
        this.writeFloat(height);
        this.writeFloat(scale);
    }
}
