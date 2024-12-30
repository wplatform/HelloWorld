package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.ServerPacket;

public class GarrisonBuildingActivated extends ServerPacket {
    public int garrPlotInstanceID;

    public GarrisonBuildingActivated() {
        super(ServerOpcode.GarrisonBuildingActivated, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(garrPlotInstanceID);
    }
}
