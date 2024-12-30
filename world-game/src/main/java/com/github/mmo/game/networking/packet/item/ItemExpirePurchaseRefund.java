package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ServerPacket;

public class ItemExpirePurchaseRefund extends ServerPacket {
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;

    public ItemExpirePurchaseRefund() {
        super(ServerOpcode.ItemExpirePurchaseRefund, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(itemGUID);
    }
}
