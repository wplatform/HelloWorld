package com.github.mmo.game.networking.packet.vehicle;


public class OnCancelExpectedRideVehicleAura extends ServerPacket {
    public OnCancelExpectedRideVehicleAura() {
        super(ServerOpcode.OnCancelExpectedRideVehicleAura, ConnectionType.instance);
    }

    @Override
    public void write() {
    }
}
