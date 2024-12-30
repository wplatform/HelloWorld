package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.ServerPacket;

public class GarrisonPlotRemoved extends ServerPacket {
    public int garrPlotInstanceID;

    public GarrisonPlotRemoved() {
        super(ServerOpcode.GarrisonPlotRemoved, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(garrPlotInstanceID);
    }
}
