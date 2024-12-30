package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SwapSubGroups extends ClientPacket {
    public ObjectGuid firstTarget = ObjectGuid.EMPTY;
    public ObjectGuid secondTarget = ObjectGuid.EMPTY;
    public byte partyIndex;

    public SwapSubGroups(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readByte();
        firstTarget = this.readPackedGuid();
        secondTarget = this.readPackedGuid();
    }
}
