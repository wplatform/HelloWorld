package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ServerPacket;

public class ItemPurchaseRefundResult extends ServerPacket {
    public byte result;
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
    public ItemPurchasecontents contents;

    public ItemPurchaseRefundResult() {
        super(ServerOpcode.ItemPurchaseRefundResult, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(itemGUID);
        this.writeInt8(result);
        this.writeBit(contents != null);
        this.flushBits();

        if (contents != null) {
            contents.write(this);
        }
    }
}
