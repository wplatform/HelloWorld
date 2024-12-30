package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.movement.model.MovementInfo;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class MoveDismissVehicle extends ClientPacket {
    public MovementInfo status;

    public MoveDismissVehicle(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        status = MovementExtensions.readMovementInfo(this);
    }
}
