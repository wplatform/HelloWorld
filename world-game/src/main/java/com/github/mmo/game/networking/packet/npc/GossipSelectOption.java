package com.github.mmo.game.networking.packet.npc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GossipSelectOption extends ClientPacket {
    public ObjectGuid gossipUnit = ObjectGuid.EMPTY;
    public int gossipOptionID;

    public int gossipID;
    public String promotionCode;

    public GossipSelectOption(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        gossipUnit = this.readPackedGuid();
        gossipID = this.readUInt();
        gossipOptionID = this.readInt32();

        var length = this.<Integer>readBit(8);
        promotionCode = this.readString(length);
    }
}
