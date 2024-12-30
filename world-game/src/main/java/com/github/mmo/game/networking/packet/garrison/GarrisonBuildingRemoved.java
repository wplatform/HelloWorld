package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.ServerPacket;

public class GarrisonBuildingRemoved extends ServerPacket {
    public GarrisonType garrTypeID = GarrisonType.values()[0];
    public GarrisonError result = GarrisonError.values()[0];
    public int garrPlotInstanceID;
    public int garrBuildingID;

    public GarrisonBuildingRemoved() {
        super(ServerOpcode.GarrisonBuildingRemoved, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(garrTypeID.getValue());
        this.writeInt32((int) result.getValue());
        this.writeInt32(garrPlotInstanceID);
        this.writeInt32(garrBuildingID);
    }
}
