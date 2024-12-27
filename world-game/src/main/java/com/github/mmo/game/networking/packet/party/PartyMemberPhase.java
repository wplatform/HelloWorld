package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;

public final class PartyMemberPhase {
    public PartyMemberPhase() {
    }

    public PartyMemberPhase(int flags, int id) {
        this.flags = (short) flags;
        this.id = (short) id;
    }

    public void write(WorldPacket data) {
        data.writeInt16(flags);
        data.writeInt16(id);
    }

    public short flags;
    public short id;

}
