package com.github.mmo.game.networking.packet.transmogification;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;class TransmogrifyItems extends ClientPacket {
    public ObjectGuid npc = ObjectGuid.EMPTY;
    public Array<TransmogrifyItem> items = new Array<TransmogrifyItem>(13);
    public boolean currentSpecOnly;

    public TransmogrifyItems(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var itemsCount = this.readUInt();
        npc = this.readPackedGuid();

        for (var i = 0; i < itemsCount; ++i) {
            TransmogrifyItem item = new TransmogrifyItem();
            item.read(this);
            items.set(i, item);
        }

        currentSpecOnly = this.readBit();
    }
}
