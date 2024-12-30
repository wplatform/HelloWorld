package com.github.mmo.game.networking.packet.spell;


import java.util.ArrayList;


public class AuraUpdate extends ServerPacket {
    public boolean updateAll;
    public ObjectGuid unitGUID = ObjectGuid.EMPTY;
    public ArrayList<AuraInfo> auras = new ArrayList<>();

    public AuraUpdate() {
        super(ServerOpcode.AuraUpdate, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeBit(updateAll);
        this.writeBits(auras.size(), 9);

        for (var aura : auras) {
            aura.write(this);
        }

        this.writeGuid(unitGUID);
    }
}
