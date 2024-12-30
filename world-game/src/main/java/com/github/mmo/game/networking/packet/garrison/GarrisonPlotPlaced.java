package com.github.mmo.game.networking.packet.garrison;


import com.github.mmo.game.networking.ServerPacket;

public class GarrisonPlotPlaced extends ServerPacket {
    public GarrisonType garrTypeID = GarrisonType.values()[0];
    public GarrisonplotInfo plotInfo = new garrisonPlotInfo();

    public GarrisonPlotPlaced() {
        super(ServerOpcode.GarrisonPlotPlaced, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(garrTypeID.getValue());
        plotInfo.write(this);
    }
}
