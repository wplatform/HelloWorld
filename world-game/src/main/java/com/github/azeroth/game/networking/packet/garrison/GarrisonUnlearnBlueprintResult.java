package com.github.azeroth.game.networking.packet.garrison;

import com.github.azeroth.game.networking.ServerPacket;

public class GarrisonUnlearnBlueprintResult extends ServerPacket {
    public GarrisonType garrTypeID = GarrisonType.values()[0];
    public int buildingID;
    public GarrisonError result = GarrisonError.values()[0];

    public GarrisonUnlearnBlueprintResult() {
        super(ServerOpcode.GarrisonUnlearnBlueprintResult);
    }

    @Override
    public void write() {
        this.writeInt32(garrTypeID.getValue());
        this.writeInt32((int) result.getValue());
        this.writeInt32(buildingID);
    }
}