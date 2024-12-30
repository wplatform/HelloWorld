package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ServerPacket;

public class LootList extends ServerPacket {
    public ObjectGuid owner = ObjectGuid.EMPTY;
    public ObjectGuid lootObj = ObjectGuid.EMPTY;
    public ObjectGuid master = null;
    public ObjectGuid roundRobinWinner = null;

    public LootList() {
        super(ServerOpcode.LootList, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(owner);
        this.writeGuid(lootObj);

        this.writeBit(master != null);
        this.writeBit(roundRobinWinner != null);
        this.flushBits();

        if (master != null) {
            this.writeGuid(master.getValue());
        }

        if (roundRobinWinner != null) {
            this.writeGuid(roundRobinWinner.getValue());
        }
    }
}
