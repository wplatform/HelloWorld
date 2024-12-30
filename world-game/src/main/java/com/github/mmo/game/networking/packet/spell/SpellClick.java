package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SpellClick extends ClientPacket {
    public ObjectGuid spellClickUnitGuid = ObjectGuid.EMPTY;
    public boolean tryAutoDismount;
    public boolean isSoftInteract;

    public SpellClick(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        spellClickUnitGuid = this.readPackedGuid();
        tryAutoDismount = this.readBit();
        isSoftInteract = this.readBit();
    }
}
