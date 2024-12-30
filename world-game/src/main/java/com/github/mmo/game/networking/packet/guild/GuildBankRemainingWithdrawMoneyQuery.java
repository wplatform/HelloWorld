package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class GuildBankRemainingWithdrawMoneyQuery extends ClientPacket {
    public GuildBankRemainingWithdrawMoneyQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
