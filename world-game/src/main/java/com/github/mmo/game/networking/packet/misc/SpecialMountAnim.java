package com.github.mmo.game.networking.packet.misc;


import com.github.mmo.game.networking.ServerPacket;

import java.util.ArrayList;

public class SpecialMountAnim extends ServerPacket {
    public ObjectGuid unitGUID = ObjectGuid.EMPTY;
    public ArrayList<Integer> spellVisualKitIDs = new ArrayList<>();
    public int sequenceVariation;

    public SpecialMountAnim() {
        super(ServerOpcode.SpecialMountAnim, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(unitGUID);
        this.writeInt32(spellVisualKitIDs.size());
        this.writeInt32(sequenceVariation);

        for (var id : spellVisualKitIDs) {
            this.writeInt32(id);
        }
    }
}
