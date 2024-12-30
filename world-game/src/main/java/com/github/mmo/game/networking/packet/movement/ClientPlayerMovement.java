package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.movement.model.MovementInfo;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class ClientPlayerMovement extends ClientPacket {
    public MovementInfo status;

    public ClientPlayerMovement(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        status = MovementIOUtil.readMovementInfo(this);
    }
}
