package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ServerPacket;

public class LootReleaseAll extends ServerPacket {
    public LootReleaseAll() {
        super(ServerOpcode.LootReleaseAll, ConnectionType.instance);
    }

    @Override
    public void write() {
    }
}
