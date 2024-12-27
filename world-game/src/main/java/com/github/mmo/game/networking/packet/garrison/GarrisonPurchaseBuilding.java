package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;class GarrisonPurchaseBuilding extends ClientPacket {
    public ObjectGuid npcGUID = ObjectGuid.EMPTY;

    public int buildingID;

    public int plotInstanceID;

    public GarrisonPurchaseBuilding(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        npcGUID = this.readPackedGuid();
        plotInstanceID = this.readUInt();
        buildingID = this.readUInt();
    }
}
