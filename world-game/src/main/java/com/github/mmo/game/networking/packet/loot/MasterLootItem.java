package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;class MasterLootItem extends ClientPacket {
    public Array<lootRequest> loot = new Array<LootRequest>(1000);
    public ObjectGuid target = ObjectGuid.EMPTY;

    public MasterLootItem(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var count = this.readUInt();
        target = this.readPackedGuid();

        for (var i = 0; i < count; ++i) {
            LootRequest lootRequest = new LootRequest();
            lootRequest.object = this.readPackedGuid();
            lootRequest.lootListID = this.readUInt8();
            loot.set(i, lootRequest);
        }
    }
}
