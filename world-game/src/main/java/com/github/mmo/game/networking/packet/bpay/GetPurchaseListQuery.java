package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

public final class GetPurchaseListQuery extends ClientPacket {
    public GetPurchaseListQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
