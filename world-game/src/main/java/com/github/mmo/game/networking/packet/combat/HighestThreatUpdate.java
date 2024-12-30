package com.github.mmo.game.networking.packet.combat;


import java.util.ArrayList;


public class HighestThreatUpdate extends ServerPacket {
    public ObjectGuid unitGUID = ObjectGuid.EMPTY;
    public ArrayList<ThreatInfo> threatList = new ArrayList<>();
    public ObjectGuid highestThreatGUID = ObjectGuid.EMPTY;

    public HighestThreatUpdate() {
        super(ServerOpcode.HighestThreatUpdate, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(unitGUID);
        this.writeGuid(highestThreatGUID);
        this.writeInt32(threatList.size());

        for (var threatInfo : threatList) {
            this.writeGuid(threatInfo.unitGUID);
            this.writeInt64(threatInfo.threat);
        }
    }
}
