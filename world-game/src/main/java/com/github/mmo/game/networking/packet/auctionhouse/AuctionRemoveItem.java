package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class AuctionRemoveItem extends ClientPacket {
    public ObjectGuid auctioneer = ObjectGuid.EMPTY;
    public int auctionID;
    public int itemID;
    public AddOnInfo taintedBy = null;

    public AuctionRemoveItem(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        auctioneer = this.readPackedGuid();
        auctionID = this.readUInt();
        itemID = this.readInt32();

        if (this.readBit()) {
            taintedBy = new AddOnInfo();
            taintedBy.getValue().read(this);
        }
    }
}
