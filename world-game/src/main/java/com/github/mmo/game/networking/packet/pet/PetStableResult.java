package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.ServerPacket;

public class PetStableResult extends ServerPacket {
    public Stableresult result = StableResult.values()[0];

    public PetStableResult() {
        super(ServerOpcode.PetStableResult, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt8((byte) result.getValue());
    }
}
