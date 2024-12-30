package com.github.mmo.game.networking.packet.duel;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class DuelResponse extends ClientPacket {
    public ObjectGuid arbiterGUID = ObjectGuid.EMPTY;
    public boolean accepted;
    public boolean forfeited;

    public DuelResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        arbiterGUID = this.readPackedGuid();
        accepted = this.readBit();
        forfeited = this.readBit();
    }
}
