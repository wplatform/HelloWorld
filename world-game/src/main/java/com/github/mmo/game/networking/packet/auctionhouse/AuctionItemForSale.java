package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.WorldPacket;

public final class AuctionItemForSale {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public int useCount;

    public AuctionItemForSale() {
    }

    public AuctionItemForSale(WorldPacket data) {
        guid = data.readPackedGuid();
        useCount = data.readUInt();
    }

    public AuctionItemForSale clone() {
        AuctionItemForSale varCopy = new AuctionItemForSale();

        varCopy.guid = this.guid;
        varCopy.useCount = this.useCount;

        return varCopy;
    }
}
