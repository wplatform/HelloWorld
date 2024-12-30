package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class CancelCast extends ClientPacket {
    public int spellID;
    public ObjectGuid castID = ObjectGuid.EMPTY;

    public CancelCast(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        castID = this.readPackedGuid();
        spellID = this.readUInt();
    }
}
