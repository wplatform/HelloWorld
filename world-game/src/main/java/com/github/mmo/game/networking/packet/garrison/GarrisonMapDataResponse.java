package com.github.mmo.game.networking.packet.garrison;


import java.util.*;import com.github.mmo.game.networking.ServerPacket;
public class GarrisonMapDataResponse extends ServerPacket {
    public ArrayList<GarrisonBuildingMapData> buildings = new ArrayList<>();

    public GarrisonMapDataResponse() {
        super(ServerOpcode.GarrisonMapDataResponse, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(buildings.size());

        for (var landmark : buildings) {
            landmark.write(this);
        }
    }
}