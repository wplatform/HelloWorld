package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ServerPacket;

public class InventoryFullOverflow extends ServerPacket {
    public InventoryFullOverflow() {
        super(ServerOpcode.InventoryFullOverflow);
    }

    @Override
    public void write() {
    }
}
