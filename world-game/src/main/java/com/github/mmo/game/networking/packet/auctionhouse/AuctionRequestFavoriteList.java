package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class AuctionRequestFavoriteList extends ClientPacket {
    public AuctionRequestFavoriteList(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
