package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class MoveSetVehicleRecIdAck extends ClientPacket {
    public movementAck data = new movementAck();
    public int vehicleRecID;

    public MoveSetVehicleRecIdAck(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        data.read(this);
        vehicleRecID = this.readInt32();
    }
}
