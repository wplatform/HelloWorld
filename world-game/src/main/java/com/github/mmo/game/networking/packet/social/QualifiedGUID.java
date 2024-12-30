package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.networking.WorldPacket;

public final class QualifiedGUID {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public int virtualRealmAddress;

    public void read(WorldPacket data) {
        virtualRealmAddress = data.readUInt();
        guid = data.readPackedGuid();
    }

    public QualifiedGUID clone() {
        QualifiedGUID varCopy = new qualifiedGUID();

        varCopy.guid = this.guid;
        varCopy.virtualRealmAddress = this.virtualRealmAddress;

        return varCopy;
    }
}
