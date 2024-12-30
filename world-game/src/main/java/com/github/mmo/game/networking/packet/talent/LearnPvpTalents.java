package com.github.mmo.game.networking.packet.talent;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class LearnPvpTalents extends ClientPacket {
    public Array<PvPTalent> talents = new Array<PvPTalent>(4);

    public LearnPvpTalents(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var size = this.readUInt();

        for (var i = 0; i < size; ++i) {
            talents.set(i, new PvPTalent(this));
        }
    }
}
