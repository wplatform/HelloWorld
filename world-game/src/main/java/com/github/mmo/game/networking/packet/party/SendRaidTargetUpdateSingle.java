package com.github.mmo.game.networking.packet.party;


import com.github.mmo.game.networking.*;class SendRaidTargetUpdateSingle extends ServerPacket {
    public byte partyIndex;
    public ObjectGuid target = ObjectGuid.EMPTY;
    public ObjectGuid changedBy = ObjectGuid.EMPTY;
    public byte symbol;

    public SendRaidTargetUpdateSingle() {
        super(ServerOpcode.SendRaidTargetUpdateSingle);
    }

    @Override
    public void write() {
        this.writeInt8(partyIndex);
        this.writeInt8(symbol);
        this.writeGuid(target);
        this.writeGuid(changedBy);
    }
}