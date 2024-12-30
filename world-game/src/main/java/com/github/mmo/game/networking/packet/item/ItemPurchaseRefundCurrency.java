package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.WorldPacket;

final class ItemPurchaseRefundCurrency {

    public int currencyID;

    public int currencyCount;

    public void write(WorldPacket data) {
        data.writeInt32(currencyID);
        data.writeInt32(currencyCount);
    }

    public ItemPurchaseRefundCurrency clone() {
        ItemPurchaseRefundCurrency varCopy = new ItemPurchaseRefundCurrency();

        varCopy.currencyID = this.currencyID;
        varCopy.currencyCount = this.currencyCount;

        return varCopy;
    }
}
