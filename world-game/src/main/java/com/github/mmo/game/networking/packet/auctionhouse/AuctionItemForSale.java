package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.WorldPacket;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
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
