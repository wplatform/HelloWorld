package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class SetTradeCurrency extends ClientPacket {
    public int type;
    public int quantity;

    public SetTradeCurrency(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        type = this.readUInt();
        quantity = this.readUInt();
    }
}
