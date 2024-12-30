package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class AuctionSetFavoriteItem extends ClientPacket {
    public auctionFavoriteInfo item = new auctionFavoriteInfo();
    public boolean isNotFavorite = true;

    public AuctionSetFavoriteItem(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        isNotFavorite = this.readBit();
        item = new auctionFavoriteInfo(this);
    }
}
