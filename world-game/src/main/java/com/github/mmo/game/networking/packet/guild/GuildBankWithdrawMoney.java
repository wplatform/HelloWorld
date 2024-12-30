package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildBankWithdrawMoney extends ClientPacket {
    public ObjectGuid banker = ObjectGuid.EMPTY;
    public long money;

    public GuildBankWithdrawMoney(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        banker = this.readPackedGuid();
        money = this.readUInt64();
    }
}
