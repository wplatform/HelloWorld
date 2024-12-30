package com.github.mmo.game.networking.packet.talent;


import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class LearnTalents extends ClientPacket {

    public Array<SHORT> talents = new Array<SHORT>(PlayerConst.maxTalentTiers);

    public LearnTalents(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var count = this.<Integer>readBit(6);

        for (var i = 0; i < count; ++i) {
            talents.set(i, this.readUInt16());
        }
    }
}
