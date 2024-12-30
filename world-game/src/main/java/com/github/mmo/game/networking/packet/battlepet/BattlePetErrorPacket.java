package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.ServerPacket;

public class BattlePetErrorPacket extends ServerPacket {
    public BattlePetError result = BattlePetError.values()[0];
    public int creatureID;

    public BattlePetErrorPacket() {
        super(ServerOpcode.BattlePetError);
    }

    @Override
    public void write() {
        this.writeBits(result, 4);
        this.writeInt32(creatureID);
    }
}
