package com.github.mmo.game.networking.packet.misc;


import java.util.*;import com.github.mmo.game.networking.ServerPacket;
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
