package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;class SetPartyLeader extends ClientPacket {
    public byte partyIndex;
    public ObjectGuid targetGUID = ObjectGuid.EMPTY;

    public SetPartyLeader(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readByte();
        targetGUID = this.readPackedGuid();
    }
}
