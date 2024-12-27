package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;public class GuildBankQueryTab extends ClientPacket {
    public ObjectGuid banker = ObjectGuid.EMPTY;

    public byte tab;
    public boolean fullUpdate;

    public GuildBankQueryTab(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        banker = this.readPackedGuid();
        tab = this.readUInt8();

        fullUpdate = this.readBit();
    }
}
