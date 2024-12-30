package com.github.mmo.game.networking.packet.talent;


import com.github.mmo.game.networking.ServerPacket;

import java.util.ArrayList;

public class LearnTalentFailed extends ServerPacket {
    public int reason;
    public int spellID;
    public ArrayList<SHORT> talents = new ArrayList<>();

    public LearnTalentFailed() {
        super(ServerOpcode.LearnTalentFailed);
    }

    @Override
    public void write() {
        this.writeBits(reason, 4);
        this.writeInt32(spellID);
        this.writeInt32(talents.size());

        for (var talent : talents) {
            this.writeInt16(talent);
        }
    }
}
