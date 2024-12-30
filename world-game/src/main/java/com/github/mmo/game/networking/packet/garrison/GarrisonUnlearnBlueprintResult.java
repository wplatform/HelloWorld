package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.ServerPacket;

public class GarrisonUnlearnBlueprintResult extends ServerPacket {
    public GarrisonType garrTypeID = GarrisonType.values()[0];
    public int buildingID;
    public GarrisonError result = GarrisonError.values()[0];

    public GarrisonUnlearnBlueprintResult() {
        super(ServerOpcode.GarrisonUnlearnBlueprintResult, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(garrTypeID.getValue());
        this.writeInt32((int) result.getValue());
        this.writeInt32(buildingID);
    }
}
