package com.github.mmo.game.networking.packet.npc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class TrainerBuySpell extends ClientPacket {
    public ObjectGuid trainerGUID = ObjectGuid.EMPTY;
    public int trainerID;
    public int spellID;

    public TrainerBuySpell(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        trainerGUID = this.readPackedGuid();
        trainerID = this.readUInt();
        spellID = this.readUInt();
    }
}
